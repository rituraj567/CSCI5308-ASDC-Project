package com.CanadaEats.group13.restaurant.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.restaurant.business.DeleteErrorOperation;
import com.CanadaEats.group13.restaurant.business.DeleteSuccessOperation;
import com.CanadaEats.group13.restaurant.business.IRestaurantState;
import com.CanadaEats.group13.restaurant.business.InsertErrorOperation;
import com.CanadaEats.group13.restaurant.business.InsertSucessOperation;
import com.CanadaEats.group13.restaurant.business.UpdateErrorOperation;
import com.CanadaEats.group13.restaurant.business.UpdateSucessOperation;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;

public class RestaurantRepository implements IRestaurantRepository {

    IDatabaseConnection databaseConnection;
    Connection connection;

    public RestaurantRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<RestaurantDTO> getRestaurantResultSet(ResultSet restaurantResult,
            List<RestaurantDTO> restaurantDTOList) {
        try {
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
                restaurantDTOList.add(new RestaurantDTO(id, restaurantId, name, address, city, province, country,
                        postalCode, phone, status, userId));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return restaurantDTOList;
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        Connection connection;
        try {
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String restaurants = "select * from Restaurant WHERE status=1";
            ResultSet restaurantResult = statement.executeQuery(restaurants);

            restaurantDTOList = getRestaurantResultSet(restaurantResult, restaurantDTOList);
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
    public Map<String, String> postRestaurant(RestaurantDTO restaurantDTO) {
        Connection connection;
        try {

            String query = " insert into Restaurant (Id, RestaurantId, Name, Address, City, Province,Country,PostalCode,PhoneNumber,Status,User_UserId)"
                    + " values (?, ?, ?, ?, ?,?,?,?,?,?,?)";

            connection = databaseConnection.getDatabaseConnection();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setObject(1, null);
            preparedStmt.setString(2, UUID.randomUUID().toString());
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

            IRestaurantState restaurantState = new InsertSucessOperation();

            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = new InsertErrorOperation();

            return restaurantState.setMessage();
        }

    }

    @Override
    public RestaurantDTO getRestaurantById(int id) {
        RestaurantDTO restaurantDTO = null;
        Connection connection;
        try {
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
                restaurantDTO = new RestaurantDTO(id, restaurantId, name, address, city, province, country, postalCode,
                        phone, status, userId);

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
    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO) {

        Connection connection;

        try {
            connection = databaseConnection.getDatabaseConnection();

            String query = "update Restaurant SET  Name=?, Address=?, City=?, Province=?,Country=?,PostalCode=?,PhoneNumber=? where id="
                    + restaurantDTO.getId();

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, restaurantDTO.getName());
            preparedStmt.setString(2, restaurantDTO.getAddress());
            preparedStmt.setString(3, restaurantDTO.getCity());
            preparedStmt.setString(4, restaurantDTO.getProvince());
            preparedStmt.setString(5, restaurantDTO.getCountry());
            preparedStmt.setString(6, restaurantDTO.getPostalCode());
            preparedStmt.setString(7, restaurantDTO.getPhoneNumber());

            preparedStmt.execute();
            connection.close();
            IRestaurantState restaurantState = new UpdateSucessOperation();

            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = new UpdateErrorOperation();

            return restaurantState.setMessage();
        }

    }

    @Override
    public Map<String, String> deleteRestaurant(int restaurantId) {
        Connection connection;

        try {
            connection = databaseConnection.getDatabaseConnection();

            String query = "UPDATE Restaurant SET status=0 where id=" + restaurantId;

            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.execute();
            IRestaurantState restaurantState = new DeleteSuccessOperation();
            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = new DeleteErrorOperation();
            return restaurantState.setMessage();
        }

    }

    @Override
    public List<RestaurantDTO> searchRestaurants(String query) {
        Connection connection;
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        try {
            connection = databaseConnection.getDatabaseConnection();

            String expression = "SELECT * FROM Restaurant WHERE Name LIKE '%" + query + "%'";
            System.out.println(expression);

            Statement statement = connection.createStatement();
            ResultSet restaurantResult = statement.executeQuery(expression);

            restaurantDTOList = getRestaurantResultSet(restaurantResult, restaurantDTOList);
            System.out.println(restaurantDTOList);

            for (RestaurantDTO restaurant : restaurantDTOList) {
                System.out.println(restaurant.getName());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return restaurantDTOList;
    }

}
