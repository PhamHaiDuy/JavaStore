package fa.training.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/sms";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    private Connection connection;
    public Database(){
        this.init();
    }

    public Connection getConnection() {
        return connection;
    }

    private void init(){
        try{
            Class.forName(JDBC_DRIVER); //Đăng kí driver
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
