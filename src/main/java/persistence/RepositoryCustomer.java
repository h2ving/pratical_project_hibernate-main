package persistence;

import java.sql.ResultSet;
import java.util.List;
import javax.persistence.EntityManager;
import model.Customer;
import util.DBUtil;

public class RepositoryCustomer extends CRUDRepository<Customer>{

    private EntityManager em;

    public RepositoryCustomer() {
        em = DBUtil.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<Customer> listAllCustomers() {
        return em.createQuery("Select f from Customer as f order by f.firstName asc")
                .getResultList();
    }

    //TODO: make it actually return a list so MenuCustomer can check if username exists in the list
    public List<String> listAllCustomersByUserName(String userName) {
        return em.createQuery("SELECT c.userName FROM Customer c WHERE c.userName = :user", String.class)
                .setParameter("user", userName)
                .getResultList();
    }

    public Customer findById(int id) {
        return em.getReference(Customer.class, id);
    }

    public long listActiveCustomers() {
        return (long) em.createQuery("SELECT count(account_status) FROM Customer WHERE account_status = 1").getSingleResult();
    }

    public long listUnactiveCustomers() {
        return (long) em.createQuery("SELECT count(account_status) FROM Customer WHERE account_status = 0").getSingleResult();
    }
}
