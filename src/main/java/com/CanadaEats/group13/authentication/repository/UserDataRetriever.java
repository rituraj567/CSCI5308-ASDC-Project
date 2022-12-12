package com.CanadaEats.group13.authentication.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public class UserDataRetriever {
    public UserDetailsDto getUsersDTOFromResultSet(ResultSet resultSet) throws SQLException {
        UserDetailsDto userDetailsDto = new UserDetailsDto();

        while (resultSet.next()) {
            userDetailsDto.setId(Integer.parseInt(resultSet.getString("Id")));
            userDetailsDto.setUserId(resultSet.getString("UserId"));
            userDetailsDto.setFirstName(resultSet.getString("FirstName"));
            userDetailsDto.setLastName(resultSet.getString("LastName"));
            userDetailsDto.setEmailId(resultSet.getString("EmailId"));
            userDetailsDto.setUserName(resultSet.getString("UserName"));
            userDetailsDto.setPassword(resultSet.getString("Password"));
            userDetailsDto.setGender(resultSet.getString("Gender"));

            userDetailsDto.setBirthDate(resultSet.getDate(null));
            userDetailsDto.setAddress(resultSet.getString("Address"));
            userDetailsDto.setCity(resultSet.getString("City"));
            userDetailsDto.setProvince(resultSet.getString("Province"));
            userDetailsDto.setCountry(resultSet.getString("Country"));
            userDetailsDto.setPostalCode(resultSet.getString("PostalCode"));
            userDetailsDto.setStatus(resultSet.getInt("Status"));
            userDetailsDto.setRoleId(resultSet.getString("Role_RoleId"));
        }
        System.out.println(userDetailsDto.getCity());

        return userDetailsDto;
    }
}
