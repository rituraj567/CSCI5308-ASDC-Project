package com.CanadaEats.group13.restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.IRestaurantRepository;
import com.CanadaEats.group13.utils.StatePatternConstants;

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
    @DisplayName("getAllRestaurantsNullTest() test")
    public void getAllRestaurantsNullTest() {

        List<RestaurantDTO> restaurantDTOList = restaurantBusiness.getAllRestaurants();
        RestaurantDTO restaurantDTO = restaurantDTOList.get(0);
        restaurantDTO.setAddress(null);
        restaurantDTO.setCountry(null);
        assertEquals(null, restaurantDTO.getAddress());
        assertEquals(null, restaurantDTO.getCountry());

    }

    @Test
    @DisplayName("getAllRestaurantsEmptTest() test")
    public void getAllRestaurantsEmptyTest() {

        List<RestaurantDTO> restaurantDTOList = restaurantBusiness.getAllRestaurants();
        RestaurantDTO restaurantDTO = restaurantDTOList.get(0);
        restaurantDTO.setName("");
        restaurantDTO.setPostalCode("");
        assertEquals("", restaurantDTO.getName());
        assertEquals("", restaurantDTO.getPostalCode());

    }

    @Test
    @DisplayName("insertSucessTest() test")
    public void insertSucessTest() {

        RestaurantDTO restaurantDTO = DTOFactory.getInstance().createRestaurantDTO();
        restaurantDTO.setRestaurantId("123");

        Map<String, String> map = restaurantBusiness.insertRestaurant(restaurantDTO);

        assertEquals(StatePatternConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getInsertSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("insertFailureTest() test")
    public void insertFailureDuplicatesTest() {

        RestaurantDTO restaurantDTO = DTOFactory.getInstance().createRestaurantDTO();
        restaurantDTO.setRestaurantId("431");

        Map<String, String> map = restaurantBusiness.insertRestaurant(restaurantDTO);

        assertEquals(StatePatternConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getInsertError(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("updateSucessTest() test")
    public void updateSucessTest() {

        RestaurantDTO restaurantDTO = DTOFactory.getInstance().createRestaurantDTO();
        restaurantDTO.setRestaurantId("431");

        Map<String, String> map = restaurantBusiness.updateRestuarant(restaurantDTO);

        assertEquals(StatePatternConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getUpdateSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("updateFailureTest() test")
    public void updateFailureTest() {

        RestaurantDTO restaurantDTO = DTOFactory.getInstance().createRestaurantDTO();
        restaurantDTO.setRestaurantId("123");

        Map<String, String> map = restaurantBusiness.updateRestuarant(restaurantDTO);

        assertEquals(StatePatternConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getUpdateFailure(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("deleteSucessTest() test")
    public void deleteSucessTest() {

        Map<String, String> map = restaurantBusiness.deleteRestaurant("431");

        assertEquals(StatePatternConstants.getSuccessMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getDeleteSuccess(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("deleteFailureTest() test")
    public void deleteFailureTest() {

        Map<String, String> map = restaurantBusiness.deleteRestaurant("200");

        assertEquals(StatePatternConstants.getErrorMessage(), map.keySet().toArray()[0]);
        assertEquals(StatePatternConstants.getDeleteFailure(), map.values().toArray()[0]);
    }

    @Test
    @DisplayName("searchTest() test")
    public void searchTest() {

        List<RestaurantDTO> restaurantDTOs = restaurantBusiness.searchRestaurants("Passage");

        assertEquals(1, restaurantDTOs.size());
        assertEquals("Passage to India", restaurantDTOs.get(0).getName());
    }

    @Test
    @DisplayName("searchNoPresentTest() test")
    public void searchNoPresentTest() {

        List<RestaurantDTO> restaurantDTOs = restaurantBusiness.searchRestaurants("Adda");

        assertEquals(0, restaurantDTOs.size());

    }

    @AfterEach
    public void testTeardown() {
        restaurantBusiness = null;
    }
}
