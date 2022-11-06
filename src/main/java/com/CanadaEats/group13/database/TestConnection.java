package com.CanadaEats.group13.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {
    DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
    Connection connection = databaseConnection.getDatabaseConnection();

    public void runSampleQueries() {
        try {
            Statement statement = connection.createStatement();

            ResultSet userResult = statement.executeQuery("select * from User");


            while (userResult.next()) {
                String firstName = userResult.getString("FirstName").trim();
                System.out.println(" FirstName : " + firstName);
            }


            connection.close();
            userResult.close();


        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
    }


}
