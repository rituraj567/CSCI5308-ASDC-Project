package com.CanadaEats.group13.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.customer.business.CustomerPageHelpers;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;

@DisplayName("Customer Page Helpers Test")
public class CustomerPageHelpersTest {

    CustomerMock customerMock;
    List<List<MenuItemDto>> menuItems;

    @BeforeEach

    public void setUp() {
        customerMock = new CustomerMock();
        menuItems = customerMock.getMenuItems();
    }

    @Test
    @DisplayName("getMenuItems() test")
    public void getMenuItemsTest() {

        assertEquals(1, menuItems.size());
        assertEquals("Miso Ramen", menuItems.get(0).get(0).getName());
        assertEquals("441", menuItems.get(0).get(0).getMenuId());
        assertEquals(10, menuItems.get(0).get(0).getPrice());
    }

    @Test
    @DisplayName("getMenuItemsNull() test")
    public void getMenuItemsNull() {
        MenuItemDto menuItemDto = menuItems.get(0).get(0);
        menuItemDto.setDescription(null);
        menuItemDto.setName(null);
        assertEquals(null, menuItems.get(0).get(0).getDescription());
        assertEquals(null, menuItems.get(0).get(0).getName());

    }

    @Test
    @DisplayName("getMenuItemsEmpty() test")
    public void getMenuItemsEmpty() {
        MenuItemDto menuItemDto = menuItems.get(0).get(0);
        menuItemDto.setDescription("");
        menuItemDto.setName("");
        assertEquals("", menuItems.get(0).get(0).getDescription());
        assertEquals("", menuItems.get(0).get(0).getName());

    }

    @Test
    @DisplayName("searchMenuItems() test")
    public void searchMenuItemsTest() {
        List<List<MenuItemDto>> result = CustomerPageHelpers.searchMenuItems(menuItems, "Miso Ramen");
        assertEquals(1, result.size());
        assertEquals("Miso Ramen", result.get(0).get(0).getName());
        assertEquals("441", menuItems.get(0).get(0).getMenuId());
        assertEquals(10, menuItems.get(0).get(0).getPrice());
    }

    @Test
    @DisplayName("searchMenuItemsNoPresent() test")
    public void searchMenuItemsNoPresentTest() {
        List<List<MenuItemDto>> result = CustomerPageHelpers.searchMenuItems(menuItems, "Panner Tikka");
        assertEquals(0, result.get(0).size());
    }

    @Test
    @DisplayName("addItemsToCartTest test")
    public void addItemsToCartTest() {

        MenuItemDto menuItemDto = customerMock.getMockDTo();
        HashMap<String, int[]> mockCartMap = customerMock.getMockCart();
        CustomerPageHelpers.addItemsToMap(mockCartMap, menuItemDto);

        assertEquals(1, mockCartMap.size());
        assertTrue(mockCartMap.containsKey("Miso Ramen"));
        assertEquals(1, mockCartMap.get("Miso Ramen")[0]);
        assertEquals(10, mockCartMap.get("Miso Ramen")[1]);
    }
}
