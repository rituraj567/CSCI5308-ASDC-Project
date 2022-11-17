package com.CanadaEats.group13.restaurant.repository;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;

import java.util.List;

public interface IRestaurantRepository {
    public List<RestaurantDTO> getAllRestaurants();
    public void postRestaurant(RestaurantDTO restaurantDTO);
}
