package fa.training.dao;

import fa.training.common.Database;
import fa.training.entities.Customer;
import fa.training.entities.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDAO {
    private Database database;

    public OrderDAO() {
        this.database = new Database();
    }
    public List<Order> getAllOrdersByCustomerId(int customerId) {
        List<Order> listOfOrder = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id = ?";
        try {
            PreparedStatement statement = database.getConnection().prepareStatement(sql);
            statement.setInt(1, customerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order(rs.getInt("order_id"),rs.getDate("order_date"),
                        rs.getInt("customer_id"),rs.getInt("employee_id"),rs.getDouble("total"));
                listOfOrder.add(order);
            }
            for (Order order : listOfOrder) {
                System.out.println(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfOrder;
    }

}
