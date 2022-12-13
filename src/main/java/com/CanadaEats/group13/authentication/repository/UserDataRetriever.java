package com.CanadaEats.group13.authentication.repository;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.common.DTOFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDataRetriever {
    public UserDetailsDto getUsersDTOFromResultSet(ResultSet resultSet) throws SQLException {
        UserDetailsDto userDetailsDto = DTOFactory.getInstance().createUserDetailsDto();

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

        return userDetailsDto;
    }
}
