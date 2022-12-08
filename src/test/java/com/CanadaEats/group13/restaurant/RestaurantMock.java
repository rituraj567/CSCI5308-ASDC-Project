package com.CanadaEats.group13.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.CanadaEats.group13.restaurant.business.DeleteErrorOperation;
import com.CanadaEats.group13.restaurant.business.DeleteSuccessOperation;
import com.CanadaEats.group13.restaurant.business.IRestaurantState;
import com.CanadaEats.group13.restaurant.business.InsertErrorOperation;
import com.CanadaEats.group13.restaurant.business.InsertSucessOperation;
import com.CanadaEats.group13.restaurant.business.UpdateErrorOperation;
import com.CanadaEats.group13.restaurant.business.UpdateSucessOperation;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.IRestaurantRepository;

public class RestaurantMock implements IRestaurantRepository {
    public List<RestaurantDTO> getAllRestaurants() {
        List<RestaurantDTO> restaurants = new ArrayList<>();
        restaurants.add(new RestaurantDTO(1, "431", "Passage to India", "Spring Garden", "Halifax",
                "Nova Scotia", "Canada", "B3J 2KL", "123457890", "1", "0f0482eb-1a3a-4ada-88f5-b93e46971abc"));
        return restaurants;
    }

    @Override
    public Map<String, String> postRestaurant(RestaurantDTO restaurantDTO) {
        IRestaurantState restaurantState;
        if (restaurantDTO.getRestaurantId() == "431") {
            restaurantState = new InsertErrorOperation();
            return restaurantState.setMessage();
        }
        restaurantState = new InsertSucessOperation();
        return restaurantState.setMessage();

    }

    @Override
    public RestaurantDTO getRestaurantById(int id) {
        List<RestaurantDTO> restaurants = getAllRestaurants();
        return restaurants.get(id);
    }

    @Override
    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO) {
        IRestaurantState restaurantState;
        if (restaurantDTO.getRestaurantId() == "431") {
            restaurantState = new UpdateSucessOperation();
            return restaurantState.setMessage();
        }
        restaurantState = new UpdateErrorOperation();
        return restaurantState.setMessage();

    }

    @Override
    public Map<String, String> deleteRestaurant(int restaurantId) {
        IRestaurantState restaurantState;
        if (restaurantId == 1) {
            restaurantState = new DeleteSuccessOperation();
            return restaurantState.setMessage();
        }

        restaurantState = new DeleteErrorOperation();
        return restaurantState.setMessage();
    }

    @Override
    public List<RestaurantDTO> searchRestaurants(String query) {
        // TODO Auto-generated method stub
        return null;
    }
}
