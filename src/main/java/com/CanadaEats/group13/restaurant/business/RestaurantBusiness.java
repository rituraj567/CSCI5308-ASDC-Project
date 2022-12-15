package com.CanadaEats.group13.restaurant.business;

import java.util.List;
import java.util.Map;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.IRestaurantRepository;

public class RestaurantBusiness implements IRestaurantBusiness {

    IRestaurantRepository repository;

    public RestaurantBusiness(IRestaurantRepository respository) {
        this.repository = respository;
    }

    @Override
    public List<RestaurantDTO> getAllRestaurants() {

        return repository.getAllRestaurants();

    }

    @Override
    public Map<String, String> insertRestaurant(RestaurantDTO restaurantDTO) {
        return repository.postRestaurant(restaurantDTO);

    }

    @Override
    public RestaurantDTO getRestaurantById(String id) {
        return repository.getRestaurantById(id);

    }

    @Override
    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO) {
        return repository.updateRestuarant(restaurantDTO);

    }

    @Override
    public Map<String, String> deleteRestaurant(String restaurantId) {
        return repository.deleteRestaurant(restaurantId);

    }

    @Override
    public List<RestaurantDTO> searchRestaurants(String query) {
        return repository.searchRestaurants(query);
    }

}
