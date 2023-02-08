package co.edu.unisinu.desarrollo1.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection { 

    private final String url = "jdbc:mysql://localhost:3306/offersell";
    private final String username = "root";
    private final String password = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
//            System.out.println("DB connected in port "+connection.getClientInfo().getProperty("PORT")+" with localhost");
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
