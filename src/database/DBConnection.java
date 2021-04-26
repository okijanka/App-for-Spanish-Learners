package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = initializeConnection();

    public static Connection getConnection(){
        return connection;
    }

    private static Connection initializeConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/projekt_hiszpania_db?user=root&password=cisco");
        } catch (SQLException ex) {
            throw new IllegalStateException("Connection could not be established", ex);
        }
    }
}
