package com.CanadaEats.group13.customer.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;

public class CustomerPageHelpers {

    private static HashMap<String, int[]> cartMap = new HashMap<>();

    public static List<List<MenuItemDto>> getMenuItems(String id) {
        IRestaurantOwnerBusiness restaurantOwnerBusiness = new RestaurantOwnerBusiness(
                new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
        List<RestaurantOwnerDto> menus = restaurantOwnerBusiness.getAllMenus(id);
        List<RestaurantOwnerDto> restaurantMenus = new ArrayList<>();

        for (RestaurantOwnerDto menu : menus) {
            if (menu.getRestaurantId().equals(id)) {
                restaurantMenus.add(menu);

            }
        }
        List<List<MenuItemDto>> menuItems = new ArrayList<>();
        for (RestaurantOwnerDto items : restaurantMenus) {
            menuItems.add(restaurantOwnerBusiness.getMenuItems(items.getMenuId()));
        }
        return menuItems;
    }

    public static List<List<MenuItemDto>> searchMenuItems(List<List<MenuItemDto>> menus, String name) {
        List<List<MenuItemDto>> result = new ArrayList<>();
        for (List<MenuItemDto> menu : menus) {
            for (MenuItemDto item : menu) {
                List<MenuItemDto> temp = new ArrayList<>();
                if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                    temp.add(item);
                }
                result.add(temp);
            }
        }
        return result;
    }

    public static HashMap<String, int[]> addItemsToCart(MenuItemDto menuItemDto) {

        return addItemsToMap(cartMap, menuItemDto);
    }

    public static HashMap<String, int[]> addItemsToMap(HashMap<String, int[]> map, MenuItemDto menuItemDto) {
        String key = menuItemDto.getName();
        if (map.containsKey(key)) {
            int[] values = map.get(key);
            values[0] += 1;
            values[1] += menuItemDto.getPrice();
        } else {
            int[] values = new int[] { 1, menuItemDto.getPrice() };
            map.put(key, values);
        }

        return map;

    }

    public static HashMap<String, int[]> getCartItems() {
        return cartMap;
    }

    public static int getGrandTotal() {
        HashMap<String, int[]> cartItems = CustomerPageHelpers.getCartItems();
        int total = 0;
        for (Map.Entry<String, int[]> mapElement : cartItems.entrySet()) {
            total = total + mapElement.getValue()[1];
        }
        return total;
    }
}
