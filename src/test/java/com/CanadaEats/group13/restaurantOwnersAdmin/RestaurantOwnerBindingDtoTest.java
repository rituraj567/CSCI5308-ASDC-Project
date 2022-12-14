package com.CanadaEats.group13.restaurantOwnersAdmin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;

@DisplayName("Restaurant_Owner_Binding_DTO class tests")
public class RestaurantOwnerBindingDtoTest {

    public RestaurantBindingDto restaurantBindingDtoTest = null;

    @BeforeEach
    public void testSetUp() {
        restaurantBindingDtoTest = new RestaurantBindingDto("d0ac2c3e-4713-4a21-8f65-4aec10cab89d",
                "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174");
    }

    @Test
    @DisplayName("getRestaurantIdTest() test")
    public void getRestaurantIdTest() {
        assertEquals("d0ac2c3e-4713-4a21-8f65-4aec10cab89d", restaurantBindingDtoTest.getRestaurantId());
    }

    @Test
    @DisplayName("getRestaurantOwnerIdTest() test")
    public void getRestaurantOwnerIdTest() {
        assertEquals("9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", restaurantBindingDtoTest.getRestaurantOwnerId());
    }

    @Test
    @DisplayName("setRestaurantBindingDtoTest() test")
    public void setRestaurantIdTest() {
        String newValue = "d0ac2c3e-4713-4a21-8f65-4aec10cab89w";
        restaurantBindingDtoTest.setRestaurantId(newValue);
        assertEquals(newValue, restaurantBindingDtoTest.getRestaurantId());
    }

    @Test
    @DisplayName("setRestaurantOwnerIdTest() test")
    public void setRestaurantOwnerIdTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80175";
        restaurantBindingDtoTest.setRestaurantOwnerId(newValue);
        assertEquals(newValue, restaurantBindingDtoTest.getRestaurantOwnerId());
    }

}
