package com.CanadaEats.group13.repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.shared.dto.UserDetailsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepository implements IUserRepository{

    DatabaseConnection databaseConnection;
    Connection connection;

    public UserRepository() {

    }

    public UserDetailsResponseModel registerUser(UserDetailsDto userDetails)
    {
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();
        try
        {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String getUser = "select * from User where UserName = '" + userDetails.getUserName() + "'";
            ResultSet userResult = statement.executeQuery(getUser);

            if(userResult.getFetchSize() == 0)
            {
                String insertUser = "insert into User (UserId, FirstName, LastName, EmailId, UserName, Password, MobileNumber, Gender, BirthDate, Address, City, Province, Country, PostalCode, Status, Role_RoleId) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement prepStat=connection.prepareStatement(insertUser);
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

                if(result > 0)
                {
                    BeanUtils.copyProperties(userDetails, userResponse);
                    System.out.println("Success : UserRepository - registerUser()");
                }
                else
                {
                    System.out.println("Failure : UserRepository - registerUser()");
                }
            }
            connection.close();
            statement.close();
            userResult.close();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
        }

        return userResponse;
    }
}
