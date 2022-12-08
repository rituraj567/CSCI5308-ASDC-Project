package com.CanadaEats.group13.restaurantOwner.repository;

import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.restaurantOwner.dto.RestaurantOwnerDto;

import java.sql.Connection;
import java.util.List;

public class RestaurantOwnerRepository implements IRestaurantOwnerRepository{

    IDatabaseConnection databaseConnection;
    Connection connection;

    public RestaurantOwnerRepository(IDatabaseConnection databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    @Override
    public List<RestaurantOwnerDto> getAllRestaurantOwners() {
        return null;
    }

    @Override
    public void postRestaurant(RestaurantOwnerDto restaurantOwnerDto) {

    }

    @Override
    public RestaurantOwnerDto getRestaurantOwner(int id) {
        return null;
    }

    @Override
    public void updateRestaurantOwner(RestaurantOwnerDto restaurantOwnerDto) {

    }

    @Override
    public void deleteRestaurantOwner(int RestaurantOwnerId) {

    }

    @Override
    public List<RestaurantOwnerDto> searchRestaurantOwner(String query) {
        return null;
    }
}
