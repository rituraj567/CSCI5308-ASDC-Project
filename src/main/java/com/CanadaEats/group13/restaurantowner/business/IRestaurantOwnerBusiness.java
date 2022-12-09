package com.CanadaEats.group13.restaurantowner.business;

import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;

import java.util.List;

public interface IRestaurantOwnerBusiness {
    List<RestaurantOwnerDto> getAllMenus(String restaurantId);
    boolean addMenu(String restaurantId, MenuDto menuDto);
}
