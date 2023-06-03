package fa.training.main;

import fa.training.dao.CustomerDAO;
import fa.training.dao.CustomerDAOImpl;
import fa.training.dao.OrderDAO;

import java.util.Scanner;

public class SaleManagement {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("2.List all orders. ");
            System.out.println("5.Add customer. ");
            System.out.println("8.Add orders. ");
            System.out.println("0.Exit");
            System.out.println("Choose command: ");
            int choose = scanner.nextInt();
            switch (choose){
                case 0:
                    check = false;
                    break;
                case 2:
                    System.out.print("Enter customerId: ");
                    int id = scanner.nextInt();
                    orderDAO.getAllOrdersByCustomerId(id);
                    break;
                case 5:
                    customerDAOImpl.addCustomer();
                    break;
                case 8:
                    break;

            }



        }
    }
}
