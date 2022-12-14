package com.CanadaEats.group13.customer.dto;

public class RatingDto {
    private String restaurantId;
    private String UserId;
    private int ratingNumber;
    private String description;

    public RatingDto() {
    }

    public RatingDto(String restaurantId, String userId, int ratingNumber, String description) {
        this.restaurantId = restaurantId;
        UserId = userId;
        this.ratingNumber = ratingNumber;
        this.description = description;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
