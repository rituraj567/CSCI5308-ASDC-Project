package com.CanadaEats.group13.restaurantOwnersAdmin.dto;

public class RestaurantBindingDto {
    private String restaurantId;
    private String restaurantOwnerId;

    public RestaurantBindingDto() {
    }

    public RestaurantBindingDto(String restaurantId, String restaurantOwnerId) {
        this.restaurantId = restaurantId;
        this.restaurantOwnerId = restaurantOwnerId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantOwnerId() {
        return restaurantOwnerId;
    }

    public void setRestaurantOwnerId(String restaurantOwnerId) {
        this.restaurantOwnerId = restaurantOwnerId;
    }
}
