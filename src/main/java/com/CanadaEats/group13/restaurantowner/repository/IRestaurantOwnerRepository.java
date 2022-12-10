package com.CanadaEats.group13.restaurantowner.repository;

import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.model.request.MenuItemRequestModel;
import com.CanadaEats.group13.restaurantowner.model.request.MenuRequestModel;

import java.util.List;

public interface IRestaurantOwnerRepository {
    List<RestaurantOwnerDto> getAllMenus(String restaurantId);
    boolean addMenu(MenuRequestModel menuRequestModel);
    boolean addMenuItem(MenuItemRequestModel menuItemRequestModel);
    List<MenuItemDto> getMenuItems(String menuId);
    boolean deleteMenu(String menuId);
}
