package com.CanadaEats.group13.restaurantOwnersAdmin.repository;

import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;

import java.util.List;

public interface IRestaurantOwnerAdminRepository {
    public List<RestaurantOwnerAdminDto> getAllRestaurantOwners();
    public void postRestaurantOwnerAdmin(RestaurantOwnerAdminDto restaurantOwnerAdminDto);
    public RestaurantOwnerAdminDto getRestaurantOwner(int id);
    public void updateRestaurantOwner(RestaurantOwnerAdminDto restaurantOwnerAdminDto);
    public void deleteRestaurantOwner(int RestaurantOwnerId);
    public List<RestaurantOwnerAdminDto> searchRestaurantOwner(String query);

    void bindRestaurantOwner(RestaurantBindingDto restaurantBindingDto);
}
