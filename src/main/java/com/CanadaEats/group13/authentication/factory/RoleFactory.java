package com.CanadaEats.group13.authentication.factory;

public class RoleFactory {
    public IRole createRole(String roleName) {
        if (roleName == null || roleName.isEmpty()) {
            return null;
        }
        switch (roleName) {
            case "Admin":
                return new AdminRole();
            case "Customer":
                return new CustomerRole();
            case "RestaurantOwner":
                return new RestaurantOwnerRole();
            case "DeliveryPerson":
                return new DeliveryPersonRole();
            default:
                throw new IllegalArgumentException("Unknown Role");
        }
    }
}
