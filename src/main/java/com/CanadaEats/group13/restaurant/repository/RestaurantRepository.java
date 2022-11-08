package com.CanadaEats.group13.restaurant.repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepository implements IRestaurantRepository {

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        DatabaseConnection databaseConnection;
        Connection connection;
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.getDatabaseConnection();
            String restaurants = "select * from Restaurant";
            ResultSet restaurantResult = statement.executeQuery(restaurants);


            while (restaurantResult.next()) {
                int id = Integer.parseInt(restaurantResult.getString("Id"));
                String restaurantId = restaurantResult.getString("RestaurantId");
                String name = restaurantResult.getString("Name");
                String address = restaurantResult.getString("Address");
                String city = restaurantResult.getString("City");
                String province = restaurantResult.getString("Province");
                String country = restaurantResult.getString("Country");
                String postalCode = restaurantResult.getString("PostalCode");
                String phone = restaurantResult.getString("PhoneNumber");
                String ownerId = restaurantResult.getString("OwnerId");
                String status = restaurantResult.getString("Status");
                String userId = restaurantResult.getString("User_UserId");
                restaurantDTOList.add(new RestaurantDTO(id, restaurantId, name, address, city, province, country, postalCode, phone, ownerId, status, userId));
            }

            System.out.println("Restaurants");
            for (RestaurantDTO restaurant : restaurantDTOList) {
                System.out.println(restaurant.getName());
            }
            connection.close();
            statement.close();
            restaurantResult.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        return restaurantDTOList;
    }
}
