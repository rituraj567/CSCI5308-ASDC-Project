package com.CanadaEats.group13.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.CanadaEats.group13.utils.ApplicationConstants;

public class DatabaseConnection implements IDatabaseConnection {
    private static DatabaseConnection databaseConnection = null;
    private Connection connection = null;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    @Override
    public Connection getDatabaseConnection() {

        try {
            Properties databaseProperties = new Properties();
            FileInputStream inputStream = new FileInputStream(ApplicationConstants.PROPERTY_PATH);
            databaseProperties.load(inputStream);
            String jdbcPackage = databaseProperties.getProperty(ApplicationConstants.JDBC_DRIVER);
            String url = databaseProperties.getProperty(ApplicationConstants.DATASOURCE_URL);
            String username = databaseProperties.getProperty(ApplicationConstants.SPRING_USERNAME);
            String password = databaseProperties.getProperty(ApplicationConstants.DATASOURCE_PASSWORD);
            Class.forName(
                    jdbcPackage);
            connection = DriverManager.getConnection(
                    url,
                    username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

}
