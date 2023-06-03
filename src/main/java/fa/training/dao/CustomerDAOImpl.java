package fa.training.dao;

import fa.training.entities.Customer;

import java.util.Scanner;

public class CustomerDAOImpl {
    CustomerDAO customerDAO = new CustomerDAO();

    public void addCustomer(){
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.print("Enter name: ");
            customer.setCustomerName(scanner.next());
            customerDAO.addCustomer(customer);
            check = false;
            System.out.print("Do you want to continue(Y/N): ");
            String next = scanner.next();
            if (next.equals("N") || next.equals("n")) {
                check = false;
                System.out.println("Insert success!");
            } else if (next.equals("Y") || next.equals("y")) {
                continue;
            }
        }
    }
}
