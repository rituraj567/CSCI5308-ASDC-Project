package com.CanadaEats.group13.database;

import java.sql.Connection;

import java.sql.PreparedStatement;

public interface IDatabaseConnection {
    public Connection getDatabaseConnection();

    public void closeConnection();

    public void executeInsertQuery(PreparedStatement statement);

    public void executeUpdateQuery(PreparedStatement statement);
}
