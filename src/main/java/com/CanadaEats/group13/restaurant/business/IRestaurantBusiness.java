package com.CanadaEats.group13.restaurant.business;

import java.util.List;
import java.util.Map;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;

public interface IRestaurantBusiness {
    public List<RestaurantDTO> getAllRestaurants();

    public Map<String, String> insertRestaurant(RestaurantDTO restaurantDTO);

    public RestaurantDTO getRestaurantById(String id);

    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO);

    public Map<String, String> deleteRestaurant(String restaurantId);

    public List<RestaurantDTO> searchRestaurants(String query);
}
