package com.CanadaEats.group13.restaurant;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;

@DisplayName("Restaurant DTO class tests")
public class RestaurantDTOTest {

    public RestaurantDTO restaurantDTO;

    @BeforeEach
    public void testSetup() {
        restaurantDTO = new RestaurantDTO(1, "431", "Passage to India", "Spring Garden", "Halifax",
                "Nova Scotia", "Canada", "B3J 2KL", "123457890", "1", "0f0482eb-1a3a-4ada-88f5-b93e46971abc");
    }

    @Test
    @DisplayName("getIdTest() test")
    public void getIdTest() {
        assertEquals(1, restaurantDTO.getId());
    }

    @Test
    @DisplayName("getRestaurantIdTest() test")
    public void getRestaurantIdTest() {
        assertEquals("431", restaurantDTO.getRestaurantId());
    }

    @Test
    @DisplayName("getNameTest() test")
    public void getNameTest() {
        assertEquals("Passage to India", restaurantDTO.getName());
    }

    @Test
    @DisplayName("getCityTest() test")
    public void getCityTest() {
        assertEquals("Halifax", restaurantDTO.getCity());
    }

    @Test
    @DisplayName("getProvinceTest() test")
    public void getProvinceTest() {
        assertEquals("Nova Scotia", restaurantDTO.getProvince());
    }

    @Test
    @DisplayName("getCountryTest() test")
    public void getCountryTest() {
        assertEquals("Canada", restaurantDTO.getCountry());
    }

    @Test
    @DisplayName("getPostalCodeTest() test")
    public void getPostalCodeTest() {
        assertEquals("B3J 2KL", restaurantDTO.getPostalCode());
    }

    @Test
    @DisplayName("getPhoneNumberTest() test")
    public void getPhoneNumberTest() {
        assertEquals("123457890", restaurantDTO.getPhoneNumber());
    }

    @Test
    @DisplayName("getAddressTest() test")
    public void getAddressTest() {
        assertEquals("Spring Garden", restaurantDTO.getAddress());
    }

    @Test
    @DisplayName("getStatusTest() test")
    public void getStatusTest() {
        assertEquals("1", restaurantDTO.getStatus());
    }

    @Test
    @DisplayName("getUserIdTest() test")
    public void getUserIdTest() {
        assertEquals("Spring Garden", restaurantDTO.getAddress());
    }

    @Test
    @DisplayName("setIdTest() test")
    public void setIdTest() {
        int newValue = 2;
        restaurantDTO.setId(newValue);
        assertEquals(newValue, restaurantDTO.getId());
    }

    @Test
    @DisplayName("setRestaurantIdTest() test")
    public void setRestaurantIdTest() {
        String newId = "234";
        restaurantDTO.setRestaurantId(newId);
        assertEquals(newId, restaurantDTO.getRestaurantId());
    }

    @Test
    @DisplayName("setNameTest() test")
    public void setNameTest() {
        String newName = "Passage";
        restaurantDTO.setName(newName);
        assertEquals(newName, restaurantDTO.getName());
    }

    @Test
    @DisplayName("setCityTest() test")
    public void setCityTest() {
        String newValue = "Dartmount";
        restaurantDTO.setCity(newValue);
        assertEquals(newValue, restaurantDTO.getCity());
    }

    @Test
    @DisplayName("setProvinceTest() test")
    public void setProvinceTest() {
        String newValue = "NS";
        restaurantDTO.setProvince(newValue);
        assertEquals(newValue, restaurantDTO.getProvince());
    }

    @Test
    @DisplayName("setCountryTest() test")
    public void setCountryTest() {
        String newValue = "CN";
        restaurantDTO.setCountry(newValue);
        assertEquals(newValue, restaurantDTO.getCountry());
    }

    @Test
    @DisplayName("setPostalCodeTest() test")
    public void setPostalCodeTest() {
        String newValue = "B3J 3FL";
        restaurantDTO.setPostalCode(newValue);
        assertEquals(newValue, restaurantDTO.getPostalCode());
    }

    @Test
    @DisplayName("setPhoneNumberTest() test")
    public void setPhoneNumberTest() {
        String newValue = "Passage";
        restaurantDTO.setCity(newValue);
        assertEquals(newValue, restaurantDTO.getCity());
    }

    @Test
    @DisplayName("setAddressTest() test")
    public void setAddressTest() {
        String newValue = "Dartmount Crossing";
        restaurantDTO.setAddress(newValue);
        assertEquals(newValue, restaurantDTO.getAddress());
    }

    @Test
    @DisplayName("setStatusTest() test")
    public void setStatusTest() {
        String newValue = "0";
        restaurantDTO.setStatus(newValue);
        assertEquals(newValue, restaurantDTO.getStatus());
    }

    @Test
    @DisplayName("getUserIdTest() test")
    public void setUserIdTest() {
        String newValue = "1234";
        restaurantDTO.setUserId(newValue);
        assertEquals(newValue, restaurantDTO.getUserId());
    }

    @AfterEach
    public void testTeardown() {
        restaurantDTO = null;
    }
}
