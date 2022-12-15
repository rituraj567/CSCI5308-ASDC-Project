package com.CanadaEats.group13.authentication.model.response;

public class UserLoginResponseModel {
    private String userName;
    private String roleId;
    private String userId;
    private String restaurantId;

    public UserLoginResponseModel() {
    }

    public UserLoginResponseModel(String userName, String roleId, String userId, String restaurantId) {
        this.userName = userName;
        this.roleId = roleId;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
