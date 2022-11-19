package com.CanadaEats.group13.restaurant.repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
                String status = restaurantResult.getString("Status");
                String userId = restaurantResult.getString("User_UserId");
                restaurantDTOList.add(new RestaurantDTO(id, restaurantId, name, address, city, province, country, postalCode, phone, status, userId));
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

    @Override
    public void postRestaurant(RestaurantDTO restaurantDTO) {
        DatabaseConnection databaseConnection;
        Connection connection;

        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            List<RestaurantDTO> restaurantsList = getAllRestaurants();
            int size = restaurantsList.size();
         
            String query = " insert into Restaurant (Id, RestaurantId, Name, Address, City, Province,Country,PostalCode,PhoneNumber,Status,User_UserId)"
                    + " values (?, ?, ?, ?, ?,?,?,?,?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,size+1);
            preparedStmt.setString(2,UUID.randomUUID().toString());
            preparedStmt.setString(3, restaurantDTO.getName());
            preparedStmt.setString(4, restaurantDTO.getAddress());
            preparedStmt.setString(5, restaurantDTO.getCity());
            preparedStmt.setString(6, restaurantDTO.getProvince());
            preparedStmt.setString(7, restaurantDTO.getCountry());
            preparedStmt.setString(8, restaurantDTO.getPostalCode());
            preparedStmt.setString(9, restaurantDTO.getPhoneNumber());
            preparedStmt.setInt(10, 1);
            preparedStmt.setString(11, "0f0482eb-1a3a-4ada-88f5-b93e46971abc");
        
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public RestaurantDTO getRestaurantById(int id) {
        
        DatabaseConnection databaseConnection;
        Connection connection;
        RestaurantDTO restaurantDTO=null;
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String restaurants = "select * from Restaurant where id=" + id;
            ResultSet restaurantResult = statement.executeQuery(restaurants);

            while (restaurantResult.next()) {
                String restaurantId = restaurantResult.getString("RestaurantId");
                String name = restaurantResult.getString("Name");
                String address = restaurantResult.getString("Address");
                String city = restaurantResult.getString("City");
                String province = restaurantResult.getString("Province");
                String country = restaurantResult.getString("Country");
                String postalCode = restaurantResult.getString("PostalCode");
                String phone = restaurantResult.getString("PhoneNumber");
                String status = restaurantResult.getString("Status");
                String userId = restaurantResult.getString("User_UserId");
                restaurantDTO = new RestaurantDTO(id, restaurantId, name, address, city, province, country, postalCode, phone, status, userId);
                
             System.out.println(restaurantDTO.getName());
                
            }

            connection.close();
            statement.close();
            restaurantResult.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        return restaurantDTO;
    }

    @Override
    public void updateRestuarant(RestaurantDTO restaurantDTO) {
        DatabaseConnection databaseConnection;
        Connection connection;

        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
    
            String query = "update Restaurant SET  Name=?, Address=?, City=?, Province=?,Country=?,PostalCode=?,PhoneNumber=? where id=" + restaurantDTO.getId();
   
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, restaurantDTO.getName());
            preparedStmt.setString(2, restaurantDTO.getAddress());
            preparedStmt.setString(3, restaurantDTO.getCity());
            preparedStmt.setString(4, restaurantDTO.getProvince());
            preparedStmt.setString(5, restaurantDTO.getCountry());
            preparedStmt.setString(6, restaurantDTO.getPostalCode());
            preparedStmt.setString(7, restaurantDTO.getPhoneNumber());
    
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    @Override
    public void deleteRestaurant(int restaurantId) {
        DatabaseConnection databaseConnection;
        Connection connection;

        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
    
            String query = "DELETE FROM Restaurant where id=" + restaurantId;
   
            PreparedStatement preparedStmt = connection.prepareStatement(query);
    
            preparedStmt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}
