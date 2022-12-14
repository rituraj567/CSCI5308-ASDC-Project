package com.CanadaEats.group13.customer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.UUID;

import com.CanadaEats.group13.customer.dto.RatingDto;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.utils.ApplicationConstants;

public class CustomerRepository implements ICustomerRepository {
    IDatabaseConnection databaseConnection;
    Connection connection;

    public CustomerRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public void addFeedBack(RatingDto ratingDto) {
        try {

            String query = " insert into Rating (RatingId, RestaurantId, UserId, RatingNumber, Description, Status)"
                    + " values (?, ?, ?, ?, ?,?)";

            connection = databaseConnection.getDatabaseConnection();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            preparedStmt.setObject(1, uuid.toString());
            preparedStmt.setString(2, ratingDto.getRestaurantId());
            preparedStmt.setString(3, ratingDto.getUserId());
            preparedStmt.setInt(4, ratingDto.getRatingNumber());
            preparedStmt.setString(5, ratingDto.getDescription());
            preparedStmt.setInt(6, ApplicationConstants.ACTIVE_STATUS);
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
