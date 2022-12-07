package com.CanadaEats.group13.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class DatabaseConnection implements IDatabaseConnection {
    private Connection connection = null;
    private static DatabaseConnection databaseConnection = null;

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

            FileInputStream inputStream = new FileInputStream("./src/main/resources/application.properties");
            databaseProperties.load(inputStream);
            String jdbcPackage = databaseProperties.getProperty("JDBCDriver");
            System.out.println(jdbcPackage);
            String url = databaseProperties.getProperty("spring.datasource.url");
            System.out.println(url);
            String username = databaseProperties.getProperty("spring.username");
            String password = databaseProperties.getProperty("spring.datasource.password");
            Class.forName(
                    jdbcPackage);
            connection = DriverManager.getConnection(
                    url,
                    username, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return connection;

    }

    @Override
    public void closeConnection() {

        Connection connection = getDatabaseConnection();
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void executeQuery(PreparedStatement statement) {
        try {
            statement.execute();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void executeInsertQuery(PreparedStatement statement) {
        executeQuery(statement);
    }

    @Override
    public void executeUpdateQuery(PreparedStatement statement) {
        executeQuery(statement);

    }

}
