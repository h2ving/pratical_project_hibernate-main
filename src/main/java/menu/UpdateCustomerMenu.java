package menu;

import model.Customer;
import persistence.RepositoryCustomer;

import java.util.Scanner;

public class UpdateCustomerMenu {

    RepositoryCustomer repositoryCustomer = new RepositoryCustomer();

    private int menuOptions(Scanner input) {
        System.out.println("\n/***************************************************/");
        System.out.println("Select the submenu option: ");
        System.out.println("-------------------------\n");
        System.out.println();
        System.out.println("1: Update customer phone number");
        System.out.println("2: Update customer email");
        System.out.println("99: Return to Customer Menu");
        System.out.println("100 - Return to Main Menu");
        System.out.println("\n/***************************************************/");
        return input.nextInt();
    }

    protected void menuChoice(Scanner input) {

        int userChoice;
        do {
            userChoice = menuOptions(input);
            switch (userChoice) {
                case 1:
                    menuUpdateCustomerPhoneNumber(input);
                    break;
                case 2:
                    menuUpdateCustomerEmail(input);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 99:
                    MenuCustomer.getCustomerMenu();
                    break;
                case 100:
                    MainMenu.getMainMenu();
                    break;
                default:
                    System.out.println("\nSorry, please enter valid Option");
                    menuOptions(input);
                    break;
            }// End of switch statement
        } while (userChoice != 100);
    }

    private void menuUpdateCustomerPhoneNumber(Scanner input) {
        System.out.println("Type the customer ID: ");
        int customerId = input.nextInt();

        Customer result = repositoryCustomer.findById(customerId);

        if(result != null) {
            System.out.println("Type the new customer phone number: ");
            String phone = input.next();
            result.setPhoneNumber(phone);
            repositoryCustomer.update(result);
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer not registered in our database.");
        }
    }

    private void menuUpdateCustomerEmail(Scanner input) {
        System.out.println("Type the customer ID: ");

        int customerId = input.nextInt();

        Customer result = repositoryCustomer.findById(customerId);

        if(result != null) {
            System.out.println("Type the new customer email: ");
            String email = input.next();
            result.setEmail(email);
            repositoryCustomer.update(result);
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer not registered in our database.");
        }
    }
}
