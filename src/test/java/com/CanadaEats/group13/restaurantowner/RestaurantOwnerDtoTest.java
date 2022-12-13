package com.CanadaEats.group13.restaurantowner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;

public class RestaurantOwnerDtoTest {
    RestaurantOwnerDto restaurantOwnerDto;

    @BeforeEach
    public void testSetup() {
        restaurantOwnerDto = new RestaurantOwnerDto("0e496f90-5566-42ce-b354-d1cedc73197d", "Punjabi",
                "d0ac2c3e-4713-4a21-8f65-4aec10cab89d", "Subway");
    }

    @Test
    public void getRestaurantNameTest() {
        assertEquals("Subway", restaurantOwnerDto.getRestaurantName());
    }

    @Test
    public void getMenuIdTest() {
        assertEquals("0e496f90-5566-42ce-b354-d1cedc73197d", restaurantOwnerDto.getMenuId());
    }

    @Test
    public void getNameTest() {
        assertEquals("Punjabi", restaurantOwnerDto.getName());
    }

    @Test
    public void getRestaurantIdTest() {
        assertEquals("d0ac2c3e-4713-4a21-8f65-4aec10cab89d", restaurantOwnerDto.getRestaurantId());
    }

    @Test
    public void setRestaurantNameTest() {
        String newValue = "Subway";
        restaurantOwnerDto.setRestaurantName(newValue);
        assertEquals(newValue, restaurantOwnerDto.getRestaurantName());
    }

    @Test
    public void setMenuIdTest() {
        String newValue = "0e496f90-5566-42ce-b354-d1cedc73197";
        restaurantOwnerDto.setMenuId(newValue);
        assertEquals(newValue, restaurantOwnerDto.getMenuId());
    }

    @Test
    public void setNameTest() {
        String newValue = "Panjabi";
        restaurantOwnerDto.setName(newValue);
        assertEquals(newValue, restaurantOwnerDto.getName());
    }

    @Test
    public void setRestaurantIdTest() {
        String newValue = "d0ac2c3e-4713-4a21-8f65-4aec10cab89d";
        restaurantOwnerDto.setRestaurantId(newValue);
        assertEquals(newValue, restaurantOwnerDto.getRestaurantId());
    }
}
