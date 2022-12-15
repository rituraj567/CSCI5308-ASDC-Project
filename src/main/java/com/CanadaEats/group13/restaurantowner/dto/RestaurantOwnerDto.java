package com.CanadaEats.group13.restaurantowner.dto;

import java.io.Serializable;

public class RestaurantOwnerDto implements Serializable {
    private String menuId;
    private String name;
    private String restaurantId;
    private String restaurantName;

    public RestaurantOwnerDto() {
    }

    public RestaurantOwnerDto(String menuId, String name, String restaurantId, String restaurantName) {
        this.menuId = menuId;
        this.name = name;
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }
}
