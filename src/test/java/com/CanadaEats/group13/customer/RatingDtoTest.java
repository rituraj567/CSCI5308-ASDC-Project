package com.CanadaEats.group13.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.customer.dto.RatingDto;

public class RatingDtoTest {
    RatingDto ratingDto;

    @BeforeEach
    public void testSetup() {
        ratingDto = new RatingDto("d0ac2c3e-4713-4a21-8f65-4aec10cab89d", "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", 10,
                "Best Restaurant");
    }

    @Test
    public void getRestaurantIdTest() {
        assertEquals("d0ac2c3e-4713-4a21-8f65-4aec10cab89d", ratingDto.getRestaurantId());
    }

    @Test
    public void getUserIdTest() {
        assertEquals("9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", ratingDto.getUserId());
    }

    @Test
    public void getRatingNumberTest() {
        assertEquals(10, ratingDto.getRatingNumber());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("Best Restaurant", ratingDto.getDescription());
    }

    @Test
    public void setRestaurantIdTest() {
        String newValue = "d0ac2c3e-4713-4a21-8f65-4aec10cab89d";
        ratingDto.setRestaurantId(newValue);
        assertEquals(newValue, ratingDto.getRestaurantId());
    }

    @Test
    public void setUserIdTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174";
        ratingDto.setUserId(newValue);
        assertEquals(newValue, ratingDto.getUserId());
    }

    @Test
    public void setRatingNumberTest() {
        int newValue = 10;
        ratingDto.setRatingNumber(newValue);
        assertEquals(newValue, ratingDto.getRatingNumber());
    }

    @Test
    public void setDescriptionTest() {
        String newValue = "Best Restaurant";
        ratingDto.setDescription(newValue);
        assertEquals(newValue, ratingDto.getDescription());
    }
}
