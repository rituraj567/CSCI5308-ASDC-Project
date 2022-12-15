package com.CanadaEats.group13.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.CanadaEats.group13.restaurant.business.IRestaurantState;
import com.CanadaEats.group13.restaurant.business.OperationsFactory;
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
            restaurantState = OperationsFactory.getInstance().createInsertErrorOperation();
            return restaurantState.setMessage();
        }
        restaurantState = OperationsFactory.getInstance().createInsertSuccessOperation();
        return restaurantState.setMessage();

    }

    @Override
    public RestaurantDTO getRestaurantById(String id) {
        List<RestaurantDTO> restaurants = getAllRestaurants();
        return restaurants.get(0);
    }

    @Override
    public Map<String, String> updateRestuarant(RestaurantDTO restaurantDTO) {
        IRestaurantState restaurantState;
        if (restaurantDTO.getRestaurantId() == "431") {
            restaurantState = OperationsFactory.getInstance().createUpdateSuccessOperation();
            return restaurantState.setMessage();
        }
        restaurantState = OperationsFactory.getInstance().createUpdateErrorOperation();
        return restaurantState.setMessage();

    }

    @Override
    public Map<String, String> deleteRestaurant(String restaurantId) {
        IRestaurantState restaurantState;
        if (restaurantId.equals("431")) {
            restaurantState = OperationsFactory.getInstance().createDeleteSuccessOperation();
            return restaurantState.setMessage();
        }

        restaurantState = OperationsFactory.getInstance().createDeleteErrorOperation();
        return restaurantState.setMessage();
    }

    @Override
    public List<RestaurantDTO> searchRestaurants(String query) {
        List<RestaurantDTO> restaurantDTOs = new ArrayList<>();
        for (RestaurantDTO restaurantDTO : getAllRestaurants()) {
            if (restaurantDTO.getName().contains(query)) {
                restaurantDTOs.add(restaurantDTO);
            }
        }
        return restaurantDTOs;
    }

    public RestaurantDTO getMockRestaurantDTO() {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(2);
        restaurantDTO.setName("Dominos");
        restaurantDTO.setAddress("Spring Garden");
        restaurantDTO.setCity("Halifax");
        restaurantDTO.setProvince("Nova Scotia");
        restaurantDTO.setCountry("Canada");
        return restaurantDTO;
    }
}
