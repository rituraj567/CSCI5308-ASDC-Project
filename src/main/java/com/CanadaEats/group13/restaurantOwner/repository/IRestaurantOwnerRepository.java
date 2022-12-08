package com.CanadaEats.group13.restaurantOwner.repository;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurantOwner.dto.RestaurantOwnerDto;

import java.util.List;

public interface IRestaurantOwnerRepository {
    public List<RestaurantOwnerDto> getAllRestaurantOwners();
    public void postRestaurant(RestaurantOwnerDto restaurantOwnerDto);
    public RestaurantOwnerDto getRestaurantOwner(int id);
    public void updateRestaurantOwner(RestaurantOwnerDto restaurantOwnerDto);
    public void deleteRestaurantOwner(int RestaurantOwnerId);
    public List<RestaurantOwnerDto> searchRestaurantOwner(String query);
}
