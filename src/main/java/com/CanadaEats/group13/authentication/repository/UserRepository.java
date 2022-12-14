package com.CanadaEats.group13.authentication.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.BeanUtils;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;

public class UserRepository implements IUserRepository {

    IDatabaseConnection databaseConnection;
    Connection connection;
    Statement statement;
    ResultSet userResult;

    public UserRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public UserDetailsResponseModel registerUser(UserDetailsDto userDetails) {
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();
        try {
            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();
            String getUser = "select * from User where UserName = '" + userDetails.getUserName() + "' and Status = 1";
            userResult = statement.executeQuery(getUser);

            if (userResult.next() == false) {
                String insertUser = "insert into User (UserId, FirstName, LastName, EmailId, UserName, Password, MobileNumber, Gender, BirthDate, Address, City, Province, Country, PostalCode, Status, Role_RoleId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement prepStat = connection.prepareStatement(insertUser);
                prepStat.setString(1, userDetails.getUserId());
                prepStat.setString(2, userDetails.getFirstName());
                prepStat.setString(3, userDetails.getLastName());
                prepStat.setString(4, userDetails.getEmailId());
                prepStat.setString(5, userDetails.getUserName());
                prepStat.setString(6, userDetails.getPassword());
                prepStat.setString(7, userDetails.getMobileNumber());
                prepStat.setString(8, userDetails.getGender());
                prepStat.setDate(9, userDetails.getBirthDate());
                prepStat.setString(10, userDetails.getAddress());
                prepStat.setString(11, userDetails.getCity());
                prepStat.setString(12, userDetails.getProvince());
                prepStat.setString(13, userDetails.getCountry());
                prepStat.setString(14, userDetails.getPostalCode());
                prepStat.setInt(15, userDetails.getStatus());
                prepStat.setString(16, userDetails.getRoleId());
                int result = prepStat.executeUpdate();

                if (result > 0) {
                    BeanUtils.copyProperties(userDetails, userResponse);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception : UserRepository - registerUser()");
            System.out.println(ex);
            System.out.println(ex.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                userResult.close();
            } catch (Exception ex) {
                System.out.println("Exception : UserRepository - Closing database connection in registerUser()");
            }
        }

        return userResponse;
    }

    public UserLoginResponseModel loginUser(UserLoginDto userLoginDto) {
        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel();

        try {
            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();
            String getUser = "select * from User where UserName = '" + userLoginDto.getUserName() + "' and Status = 1";
            userResult = statement.executeQuery(getUser);

            if (userResult.next()) {
                try {
                    String decryptedPassword = PasswordEncoderDecoder.getInstance()
                            .decrypt(userResult.getString(ApplicationConstants.USER_PASSWORD_COLUMN));
                    if (decryptedPassword.equals(userLoginDto.getPassword())) {
                        userLoginResponseModel.setRoleId(userResult.getString(ApplicationConstants.USER_ROLEID_COLUMN));
                        userLoginResponseModel
                                .setUserName(userResult.getString(ApplicationConstants.USER_USERNAME_COLUMN));
                        userLoginResponseModel.setUserId(userResult.getString(ApplicationConstants.USER_USERID_COLUMN));
                        String loggedInUserRoleId = userResult.getString(ApplicationConstants.USER_ROLEID_COLUMN);
                        String loggedInUserUserId = userResult.getString(ApplicationConstants.USER_USERID_COLUMN);
                        String loggedInUserUserName = userResult.getString(ApplicationConstants.USER_USERNAME_COLUMN);
                        userLoginResponseModel.setRoleId(loggedInUserRoleId);
                        userLoginResponseModel.setUserId(loggedInUserUserId);
                        userLoginResponseModel.setUserName(loggedInUserUserName);

                        if (loggedInUserRoleId.equals(ApplicationConstants.RESTAURANT_OWNER_ROLEID)) {
                            getResturantIdAndName(loggedInUserUserId, userLoginResponseModel);
                        }
                        return userLoginResponseModel;
                    } else {
                        return userLoginResponseModel;
                    }
                } catch (Exception ex) {
                    System.out.println("Exception: In Password Encoding In User Registration");
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception : UserRepository - loginUser()");
            System.out.println(ex);
            System.out.println(ex.getMessage());
        } finally {
            try {
                connection.close();
                statement.close();
                userResult.close();
            } catch (Exception ex) {
                System.out.println("Exception : UserRepository - Closing database connection in registerUser()");
            }
        }
        return userLoginResponseModel;
    }

    public void getResturantIdAndName(String userId, UserLoginResponseModel userLoginResponseModel) {
        try {
            String getUser = "select * from Restaurant where User_UserId = '" + userId + "' and Status = 1";
            userResult = statement.executeQuery(getUser);
            userResult.next();
            try {
                userLoginResponseModel.setRestaurantId(userResult.getString("RestaurantId"));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public UserDetailsDto getUsersDTOFromResultSet(ResultSet resultSet) {
        UserDetailsDto userDetailsDto = new UserDetailsDto();

        try {
            while (resultSet.next()) {
                userDetailsDto.setId(Integer.parseInt(resultSet.getString(ApplicationConstants.USER_ID_COLUMN)));
                userDetailsDto.setUserId(resultSet.getString(ApplicationConstants.USER_USERID_COLUMN));
                userDetailsDto.setFirstName(resultSet.getString(ApplicationConstants.USER_FIRSTNAME_COLUMN));
                userDetailsDto.setLastName(resultSet.getString(ApplicationConstants.USER_LASTNAME_COLUMN));
                userDetailsDto.setEmailId(resultSet.getString(ApplicationConstants.USER_EMAILID_COLUMN));
                userDetailsDto.setUserName(resultSet.getString(ApplicationConstants.USER_USERNAME_COLUMN));
                userDetailsDto.setPassword(resultSet.getString(ApplicationConstants.USER_PASSWORD_COLUMN));
                userDetailsDto.setGender(resultSet.getString(ApplicationConstants.USER_GENDER_COLUMN));

                userDetailsDto.setBirthDate(resultSet.getDate(ApplicationConstants.USER_BIRTHDATE_COLUMN));
                userDetailsDto.setAddress(resultSet.getString(ApplicationConstants.USER_ADDRESS_COLUMN));
                userDetailsDto.setCity(resultSet.getString(ApplicationConstants.USER_CITY_COLUMN));
                userDetailsDto.setProvince(resultSet.getString(ApplicationConstants.USER_PROVINCE_COLUMN));
                userDetailsDto.setCountry(resultSet.getString(ApplicationConstants.USER_COUNTRY_COLUMN));
                userDetailsDto.setPostalCode(resultSet.getString(ApplicationConstants.USER_POSTALCODE_COLUMN));
                userDetailsDto.setStatus(resultSet.getInt(ApplicationConstants.USER_STATUS_COLUMN));
                userDetailsDto.setRoleId(resultSet.getString(ApplicationConstants.USER_ROLE_ROLEID_COLUMN));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return userDetailsDto;
    }

    @Override
    public UserDetailsDto getUserDetails(String id) {
        UserDetailsDto userDetailsDto = null;
        ResultSet resultSet = null;
        try {

            connection = databaseConnection.getDatabaseConnection();
            statement = connection.createStatement();

            String getUser = "select * from User where UserId = '" + id + "'";
            resultSet = statement.executeQuery(getUser);

            userDetailsDto = getUsersDTOFromResultSet(resultSet);

        } catch (Exception ex) {
            System.out.println(ex);

        } finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (Exception ex) {
                System.out.println("Exception : UserRepository - Closing database connection in registerUser()");
            }
        }
        return userDetailsDto;

    }

    @Override
    public void updateUserProfile(UserDetailsDto userDetails) {
        Connection connection;

        try {
            connection = databaseConnection.getDatabaseConnection();

            String query = "update User SET  UserId=?, FirstName=?, LastName=?, EmailId=?, UserName=?,  MobileNumber=?, Gender=?, BirthDate=?, Address=?, City=?, Province=?, Country=?, PostalCode=?  where UserId= '"
                    + userDetails.getUserId() + "'";

            PreparedStatement prepStat = connection.prepareStatement(query);

            prepStat.setString(1, userDetails.getUserId());
            prepStat.setString(2, userDetails.getFirstName());
            prepStat.setString(3, userDetails.getLastName());
            prepStat.setString(4, userDetails.getEmailId());
            prepStat.setString(5, userDetails.getUserName());
            prepStat.setString(6, userDetails.getMobileNumber());
            prepStat.setString(7, userDetails.getGender());
            prepStat.setDate(8, userDetails.getBirthDate());
            prepStat.setString(9, userDetails.getAddress());
            prepStat.setString(10, userDetails.getCity());
            prepStat.setString(11, userDetails.getProvince());
            prepStat.setString(12, userDetails.getCountry());
            prepStat.setString(13, userDetails.getPostalCode());

            prepStat.executeUpdate();

            connection.close();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
