package com.CanadaEats.group13.restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.config.RestaurantConstants;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.IRestaurantRepository;

@DisplayName("Restaurant Business Test")
public class RestaurantBusinessTest {
    IRestaurantBusiness restaurantBusiness;

    @BeforeEach
    public void setUp() {

        IRestaurantRepository restaurantMock = new RestaurantMock();
        restaurantBusiness = new RestaurantBusiness(restaurantMock);
    }

    @Test
    @DisplayName("getAllRestaurantsTest() test")
    public void getAllRestaurantsTest() {

        List<RestaurantDTO> restaurantDTOList = restaurantBusiness.getAllRestaurants();
        assertEquals(1, restaurantDTOList.size());
        assertEquals("Passage to India", restaurantDTOList.get(0).getName());
        assertEquals("431", restaurantDTOList.get(0).getRestaurantId());
    }

    @Test
    @DisplayName("insertSucessTest() test")
    public void insertSucessTest() {

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId("123");

        Map<String, String> map = restaurantBusiness.insertRestaurant(restaurantDTO);

        assertEquals(RestaurantConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getInsertSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("insertFailureTest() test")
    public void insertFailureDuplicatesTest() {

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId("431");

        Map<String, String> map = restaurantBusiness.insertRestaurant(restaurantDTO);

        assertEquals(RestaurantConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getInsertError(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("updateSucessTest() test")
    public void updateSucessTest() {

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId("431");

        Map<String, String> map = restaurantBusiness.updateRestuarant(restaurantDTO);

        assertEquals(RestaurantConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getUpdateSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("updateFailureTest() test")
    public void updateFailureTest() {

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId("123");

        Map<String, String> map = restaurantBusiness.updateRestuarant(restaurantDTO);

        assertEquals(RestaurantConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getUpdateFailure(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("deleteSucessTest() test")
    public void deleteSucessTest() {

        Map<String, String> map = restaurantBusiness.deleteRestaurant(1);

        assertEquals(RestaurantConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getDeleteSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("deleteFailureTest() test")
    public void deleteFailureTest() {

        Map<String, String> map = restaurantBusiness.deleteRestaurant(2);

        assertEquals(RestaurantConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(RestaurantConstants.getDeleteFailure(), map.values().toArray()[0]);
    }
}
