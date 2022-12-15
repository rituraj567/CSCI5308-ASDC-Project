package com.CanadaEats.group13.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;

public class CustomerMock {
    private static HashMap<String, int[]> mockCartMap = new HashMap<>();

    public List<List<MenuItemDto>> getMenuItems() {
        List<List<MenuItemDto>> menuList = new ArrayList<>();

        menuList.add(new ArrayList<>());
        MenuItemDto menuItemDto = getMockDTo();
        menuList.get(0).add(menuItemDto);
        return menuList;
    }

    public MenuItemDto getMockDTo() {
        MenuItemDto menuItemDto = new MenuItemDto();
        menuItemDto.setDescription("best noodles");
        menuItemDto.setMenuId("441");
        menuItemDto.setName("Miso Ramen");
        menuItemDto.setPrice(10);
        return menuItemDto;
    }

    public HashMap<String, int[]> getMockCart() {
        return mockCartMap;
    }

}
