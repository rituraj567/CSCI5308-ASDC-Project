package com.CanadaEats.group13.restaurantowner.dto;

import java.io.Serializable;

public class RestaurantOwnerDto implements Serializable {
    private String MenuId;
    private String Name;
    private String RestaurantId;
    private String RestaurantName;

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRestaurantId() {
        return RestaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        RestaurantId = restaurantId;
    }
}
