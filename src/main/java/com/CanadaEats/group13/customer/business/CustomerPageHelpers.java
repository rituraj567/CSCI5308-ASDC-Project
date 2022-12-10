package com.CanadaEats.group13.customer.business;

import java.util.ArrayList;
import java.util.List;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;

public class CustomerPageHelpers {
    public static List<List<MenuItemDto>> getMenuItems(String id) {
        IRestaurantOwnerBusiness restaurantOwnerBusiness = new RestaurantOwnerBusiness(new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
        List<RestaurantOwnerDto> menus = restaurantOwnerBusiness.getAllMenus(id);
        System.out.println(menus.size());
        List<RestaurantOwnerDto> restaurantMenus = new ArrayList<>();
        System.out.println(id);
        for (RestaurantOwnerDto menu : menus) {
            if (menu.getRestaurantId().equals(id)) {
                restaurantMenus.add(menu);

            }
        }
        List<List<MenuItemDto>> menuItems = new ArrayList<>();
        for (RestaurantOwnerDto items : restaurantMenus) {
            System.out.println(items.getMenuId());
            menuItems.add(restaurantOwnerBusiness.getMenuItems(items.getMenuId()));
        }
        return menuItems;
    }
}
