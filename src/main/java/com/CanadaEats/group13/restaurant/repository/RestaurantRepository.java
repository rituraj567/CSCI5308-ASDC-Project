package com.CanadaEats.group13.restaurant.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.restaurant.business.IRestaurantState;
import com.CanadaEats.group13.restaurant.business.InsertErrorOperation;
import com.CanadaEats.group13.restaurant.business.InsertSucessOperation;
import com.CanadaEats.group13.restaurant.business.OperationsFactory;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.utils.ApplicationConstants;

public class RestaurantRepository implements IRestaurantRepository {

    IDatabaseConnection databaseConnection;

    public RestaurantRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public RestaurantDTO getRestaurantDTO(ResultSet restaurantResult) throws SQLException {
        int id = Integer.parseInt(restaurantResult.getString(ApplicationConstants.RESTAURANT_ID));
        String restaurantId = restaurantResult.getString(ApplicationConstants.RESTAURANT_UUID);
        String name = restaurantResult.getString(ApplicationConstants.RESTAURANT_NAME);
        String address = restaurantResult.getString(ApplicationConstants.RESTAURANT_ADDRESS);
        String city = restaurantResult.getString(ApplicationConstants.RESTAURANT_CITY);
        String province = restaurantResult.getString(ApplicationConstants.RESTAURANT_PROVINCE);
        String country = restaurantResult.getString(ApplicationConstants.RESTAURANT_COUNTRY);
        String postalCode = restaurantResult.getString(ApplicationConstants.RESTAURANT_POSTAL_CODE);
        String phone = restaurantResult.getString(ApplicationConstants.RESTAURANT_PHONE_NUMBER);
        String status = restaurantResult.getString(ApplicationConstants.RESTAURANT_STATUS);
        String userId = restaurantResult.getString(ApplicationConstants.RESTAURANT_USER_ID);
        return new RestaurantDTO(id, restaurantId, name, address, city, province, country,
                postalCode, phone, status, userId);
    }

    public List<RestaurantDTO> getRestaurantResultSet(ResultSet restaurantResult,
            List<RestaurantDTO> restaurantDTOList) {
        try {
            while (restaurantResult.next()) {

                restaurantDTOList
                        .add(getRestaurantDTO(restaurantResult));

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
            String restaurants = "select * from Restaurant WHERE status='" + ApplicationConstants.ACTIVE_STATUS + "'";
            ResultSet restaurantResult = statement.executeQuery(restaurants);

            restaurantDTOList = getRestaurantResultSet(restaurantResult, restaurantDTOList);
            connection.close();
            statement.close();
            restaurantResult.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return restaurantDTOList;
    }

    @Override
    public Map<String, String> postRestaurant(RestaurantDTO restaurantDTO) {
        Connection connection = null;
        try {

            String query = " insert into Restaurant (Id, RestaurantId, Name, Address, City, Province,Country,PostalCode,PhoneNumber,Status)"
                    + " values (?, ?, ?, ?, ?,?,?,?,?,?)";

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
            preparedStmt.setInt(10, ApplicationConstants.ACTIVE_STATUS);
            preparedStmt.execute();

            IRestaurantState restaurantState = new InsertSucessOperation();

            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = new InsertErrorOperation();

            return restaurantState.setMessage();
        } finally {
            try {
                connection.close();

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    }

    @Override
    public RestaurantDTO getRestaurantById(String id) {
        RestaurantDTO restaurantDTO = null;
        Connection connection;
        try {
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String restaurants = "select * from Restaurant where RestaurantId= '" + id + "'";
            ResultSet restaurantResult = statement.executeQuery(restaurants);

            while (restaurantResult.next()) {
                restaurantDTO = getRestaurantDTO(restaurantResult);
            }

            connection.close();
            statement.close();
            restaurantResult.close();
        } catch (Exception e) {
            System.out.println(e);
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
            IRestaurantState restaurantState = OperationsFactory.getInstance().createUpdateSuccessOperation();

            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = OperationsFactory.getInstance().createUpdateErrorOperation();

            return restaurantState.setMessage();
        }

    }

    @Override
    public Map<String, String> deleteRestaurant(String restaurantId) {
        Connection connection;

        try {
            connection = databaseConnection.getDatabaseConnection();

            String query = "UPDATE Restaurant SET status=0 where RestaurantId=+ '" + restaurantId + "'";

            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.execute();
            IRestaurantState restaurantState = OperationsFactory.getInstance().createDeleteSuccessOperation();
            return restaurantState.setMessage();

        } catch (Exception e) {
            System.out.println(e);
            IRestaurantState restaurantState = OperationsFactory.getInstance().createDeleteErrorOperation();
            return restaurantState.setMessage();
        }

    }

    @Override
    public List<RestaurantDTO> searchRestaurants(String query) {
        Connection connection;
        List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
        try {
            connection = databaseConnection.getDatabaseConnection();

            String expression = "SELECT * FROM Restaurant WHERE Name LIKE '%" + query + "%' and status= '"
                    + ApplicationConstants.ACTIVE_STATUS + "'";

            Statement statement = connection.createStatement();
            ResultSet restaurantResult = statement.executeQuery(expression);

            restaurantDTOList = getRestaurantResultSet(restaurantResult, restaurantDTOList);

        } catch (Exception e) {
            System.out.println(e);
        }
        return restaurantDTOList;
    }

}
