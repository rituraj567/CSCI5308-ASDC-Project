package com.CanadaEats.group13.authentication.common;

import javax.servlet.http.HttpServletResponse;

public class UserRoleStateManager {
    public static AdminState adminState;
    public static CustomerState customerState;
    public static RestaurantOwnerState restaurantOwnerState;
    public static DeliveryPersonState deliveryPersonState;

    private static IUserRoleState userRole;

    public UserRoleStateManager() {
        adminState = new AdminState();
        customerState = new CustomerState();
        restaurantOwnerState = new RestaurantOwnerState();
        deliveryPersonState = new DeliveryPersonState();
    }

    public void setAdminRole() {
        userRole = adminState;
    }

    public void setCustomerRole() {
        userRole = customerState;
    }

    public void setRestaurantOwnerRole() {
        userRole = restaurantOwnerState;
    }

    public void setDeliveryPersonRole() {
        userRole = deliveryPersonState;
    }

    public void userRoleState(HttpServletResponse response) {
        userRole.userRoleState(response);
    }

}
