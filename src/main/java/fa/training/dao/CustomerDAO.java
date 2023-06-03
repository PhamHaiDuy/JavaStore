package fa.training.dao;

import fa.training.common.Database;
import fa.training.entities.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDAO {
    private Database database;

    public CustomerDAO() {
        this.database = new Database();
    }

    public boolean addCustomer(Customer customer){
        boolean result = false;
        String sql = "INSERT INTO customer(customer_id,customer_name) VALUES (null,?)";
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setString(1, customer.getCustomerName());
            statement.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
