package com.CanadaEats.group13.customer.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.database.IDatabaseConnection;

public class CustomerRepository implements ICustomerRespository {
    UserDetailsDto userDetailsDto = null;
    ResultSet resultSet = null;
    Connection connection;
    Statement statement;
    IDatabaseConnection databaseConnection;

    public CustomerRepository(IDatabaseConnection databaseConnection) {

        this.databaseConnection = databaseConnection;
    }

    
}
