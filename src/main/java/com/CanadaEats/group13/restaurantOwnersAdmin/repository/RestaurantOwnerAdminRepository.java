package com.CanadaEats.group13.restaurantOwnersAdmin.repository;

import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestaurantOwnerAdminRepository implements IRestaurantOwnerAdminRepository {
    IDatabaseConnection databaseConnection;
    Connection connection;

    public RestaurantOwnerAdminRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<RestaurantOwnerAdminDto> getRestaurantOwnerResultSet(ResultSet restaurantOwnerResultSet,
                                                                     List<RestaurantOwnerAdminDto> restaurantOwnerAdminDtoList) {
        try {
            while (restaurantOwnerResultSet.next()) {
                int id = Integer.parseInt(restaurantOwnerResultSet.getString("Id"));
                String userId = UUID.randomUUID().toString();
                String firstName = restaurantOwnerResultSet.getString("FirstName");
                String lastName = restaurantOwnerResultSet.getString("LastName");
                String emailId = restaurantOwnerResultSet.getString("EmailId");
                String userName = restaurantOwnerResultSet.getString("UserName");
                String password = restaurantOwnerResultSet.getString("Password");
                String mobileNumber = restaurantOwnerResultSet.getString("MobileNumber");
                String gender = restaurantOwnerResultSet.getString("Gender");
                Date birthDate = restaurantOwnerResultSet.getDate("BirthDate");
                String address = restaurantOwnerResultSet.getString("Address");
                String city = restaurantOwnerResultSet.getString("City");
                String province = restaurantOwnerResultSet.getString("Province");
                String country = restaurantOwnerResultSet.getString("Country");
                String postalCode = restaurantOwnerResultSet.getString("PostalCode");
                int status = Integer.parseInt(restaurantOwnerResultSet.getString("Status"));
                String roleId = restaurantOwnerResultSet.getString("Role_RoleId");
                restaurantOwnerAdminDtoList.add(new RestaurantOwnerAdminDto(id, userId, firstName, lastName, emailId, userName, password, mobileNumber, gender, birthDate, address, city, province, country, postalCode, status, roleId));
            }

        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
        return restaurantOwnerAdminDtoList;
    }

    @Override
    public List<RestaurantOwnerAdminDto> getAllRestaurantOwners() {
        List<RestaurantOwnerAdminDto> restaurantOwnerAdminDtoList = new ArrayList<>();
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            Statement statement = this.connection.createStatement();
            String getAllRestaurantOwnersQuery = "SELECT * FROM User WHERE Role_RoleId=" + "\"" + ApplicationConstants.RESTAURANT_OWNER_ROLEID + "\"";
            ResultSet restaurantOwnersResult = statement.executeQuery(getAllRestaurantOwnersQuery);
            restaurantOwnerAdminDtoList = getRestaurantOwnerResultSet(restaurantOwnersResult, restaurantOwnerAdminDtoList);
            this.connection.close();
            statement.close();
            restaurantOwnersResult.close();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
        return restaurantOwnerAdminDtoList;
    }

    @Override
    public void postRestaurantOwnerAdmin(RestaurantOwnerAdminDto restaurantOwnerAdminDto) {
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            String query = " INSERT INTO User (UserId, FirstName, LastName, EmailId, UserName,Password,MobileNumber,Gender,BirthDate,Address,City,Province,Country,PostalCode,Status,Role_RoleId)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, UUID.randomUUID().toString());
            preparedStmt.setString(2, restaurantOwnerAdminDto.getFirstName());
            preparedStmt.setString(3, restaurantOwnerAdminDto.getLastName());
            preparedStmt.setString(4, restaurantOwnerAdminDto.getEmailId());
            preparedStmt.setString(5, restaurantOwnerAdminDto.getUserName());
            preparedStmt.setString(6, PasswordEncoderDecoder.getInstance().encrypt(restaurantOwnerAdminDto.getPassword()));
            preparedStmt.setString(7, restaurantOwnerAdminDto.getMobileNumber());
            preparedStmt.setString(8, restaurantOwnerAdminDto.getGender());
            preparedStmt.setDate(9, new Date(2001, 5, 1));
            preparedStmt.setString(10, restaurantOwnerAdminDto.getAddress());
            preparedStmt.setString(11, restaurantOwnerAdminDto.getCity());
            preparedStmt.setString(12, restaurantOwnerAdminDto.getProvince());
            preparedStmt.setString(13, restaurantOwnerAdminDto.getCountry());
            preparedStmt.setString(14, restaurantOwnerAdminDto.getPostalCode());
            preparedStmt.setInt(15, ApplicationConstants.ACTIVE_STATUS);
            preparedStmt.setString(16, ApplicationConstants.RESTAURANT_OWNER_ROLEID);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }

    }

    @Override
    public RestaurantOwnerAdminDto getRestaurantOwner(int id) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = null;
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String restaurantOwner = "SELECT * FROM User WHERE id=" + id;
            ResultSet restaurantOwnerResultSet = statement.executeQuery(restaurantOwner);

            while (restaurantOwnerResultSet.next()) {
                String userId = restaurantOwnerResultSet.getString("UserId");
                String firstName = restaurantOwnerResultSet.getString("FirstName");
                String lastName = restaurantOwnerResultSet.getString("LastName");
                String emailId = restaurantOwnerResultSet.getString("EmailId");
                String userName = restaurantOwnerResultSet.getString("UserName");
                String password = restaurantOwnerResultSet.getString("Password");
                String mobileNumber = restaurantOwnerResultSet.getString("MobileNumber");
                String gender = restaurantOwnerResultSet.getString("Gender");
                Date birthDate = restaurantOwnerResultSet.getDate("BirthDate");
                String address = restaurantOwnerResultSet.getString("Address");
                String city = restaurantOwnerResultSet.getString("City");
                String province = restaurantOwnerResultSet.getString("Province");
                String country = restaurantOwnerResultSet.getString("Country");
                String postalCode = restaurantOwnerResultSet.getString("PostalCode");
                int status = Integer.parseInt(restaurantOwnerResultSet.getString("Status"));
                String roleId = restaurantOwnerResultSet.getString("Role_RoleId");
                restaurantOwnerAdminDto = new RestaurantOwnerAdminDto(id, userId, firstName, lastName, emailId, userName, password, mobileNumber, gender, birthDate, address, city, province, country, postalCode, status, roleId);
            }
            connection.close();
            statement.close();
            restaurantOwnerResultSet.close();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
        return restaurantOwnerAdminDto;
    }

    @Override
    public void updateRestaurantOwner(RestaurantOwnerAdminDto restaurantOwnerAdminDto) {
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            String query = "UPDATE User SET FirstName=?, LastName=?, EmailId=?, UserName=?, Password=?, MobileNumber=?, Gender=?,  Address=?, City=?, Province=?, Country=?, PostalCode=?,status=? WHERE id=" + restaurantOwnerAdminDto.getId();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, restaurantOwnerAdminDto.getFirstName());
            preparedStmt.setString(2, restaurantOwnerAdminDto.getLastName());
            preparedStmt.setString(3, restaurantOwnerAdminDto.getEmailId());
            preparedStmt.setString(4, restaurantOwnerAdminDto.getUserName());
            preparedStmt.setString(5, restaurantOwnerAdminDto.getPassword());
            preparedStmt.setString(6, restaurantOwnerAdminDto.getMobileNumber());
            preparedStmt.setString(7, restaurantOwnerAdminDto.getGender());
            preparedStmt.setString(8, restaurantOwnerAdminDto.getAddress());
            preparedStmt.setString(9, restaurantOwnerAdminDto.getCity());
            preparedStmt.setString(10, restaurantOwnerAdminDto.getProvince());
            preparedStmt.setString(11, restaurantOwnerAdminDto.getCountry());
            preparedStmt.setString(12, restaurantOwnerAdminDto.getPostalCode());
            preparedStmt.setInt(13, ApplicationConstants.ACTIVE_STATUS);
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
    }

    @Override
    public void deleteRestaurantOwner(int restaurantOwnerId) {
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            PreparedStatement preparedStmt;
            String deleteQuery = "DELETE FROM User WHERE id=" + restaurantOwnerId;
            preparedStmt = connection.prepareStatement(deleteQuery);
            preparedStmt.execute();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
    }

    @Override
    public void bindRestaurantOwner(RestaurantBindingDto restaurantBindingDto) {
        try {
            this.connection = databaseConnection.getDatabaseConnection();
            String query = "UPDATE Restaurant SET User_UserId=? WHERE RestaurantId=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, restaurantBindingDto.getRestaurantOwnerId());
            preparedStmt.setString(2, restaurantBindingDto.getRestaurantId());
            preparedStmt.execute();
            connection.close();
        } catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
        }
    }
}
