package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector implements DBcredentials {
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName(driverName);
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to Bootathon Database");
            }
        } catch (Exception e) {
            System.out.println("Connection error: " + e);
        }

        return connection;
    }

}
