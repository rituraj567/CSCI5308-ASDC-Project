package com.CanadaEats.group13.restaurantOwnersAdmin.repository;

import java.util.List;

import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;

public interface IRestaurantOwnerAdminRepository {
    public List<RestaurantOwnerAdminDto> getAllRestaurantOwners();

    public void postRestaurantOwnerAdmin(RestaurantOwnerAdminDto restaurantOwnerAdminDto);

    public RestaurantOwnerAdminDto getRestaurantOwner(int id);

    public void updateRestaurantOwner(RestaurantOwnerAdminDto restaurantOwnerAdminDto);

    public void deleteRestaurantOwner(int RestaurantOwnerId);

    void bindRestaurantOwner(RestaurantBindingDto restaurantBindingDto);
}
