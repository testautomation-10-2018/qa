package pl.jsystems.qa.qaapi.databases.dbservice;

import pl.jsystems.qa.qaapi.confiduration.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null )initConnection();
        return connection;
    }

    private static void initConnection() {

        try {
            Class.forName(Configuration.DB_CLASS);
            String url = Configuration.DB_URL;
            String user = Configuration.DB_USER;
            String pass = Configuration.DB_PASSWORD;
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
