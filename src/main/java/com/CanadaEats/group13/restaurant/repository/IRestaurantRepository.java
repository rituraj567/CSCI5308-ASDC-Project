package com.CanadaEats.group13.restaurant.repository;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;

import java.util.List;
import java.util.Map;

public interface IRestaurantRepository {
    public List<RestaurantDTO> getAllRestaurants();

    public Map<String, String> postRestaurant(RestaurantDTO restaurantDTO);

    public RestaurantDTO getRestaurantById(String id);

    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO);

    public Map<String, String> deleteRestaurant(int restaurantId);

    public List<RestaurantDTO> searchRestaurants(String query);
}
