package com.CanadaEats.group13.restaurantowner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;

public class MenuItemDtoTest {
    MenuItemDto menuItemDto;

    @BeforeEach
    public void testSetup() {
        menuItemDto = new MenuItemDto("0e496f90-5566-42ce-b354-d1cedc73197d", "99496f90-5566-42ce-b354-d1cedc73197d",
                "Paratha", "Best Paratha", 50);
    }

    @Test
    public void getMeuIdTest() {
        assertEquals("0e496f90-5566-42ce-b354-d1cedc73197d", menuItemDto.getMenuId());
    }

    @Test
    public void getMeuItemIdTest() {
        assertEquals("99496f90-5566-42ce-b354-d1cedc73197d", menuItemDto.getMenuItemId());
    }

    @Test
    public void getNameTest() {
        assertEquals("Paratha", menuItemDto.getName());
    }

    @Test
    public void getDescriptionTest() {
        assertEquals("Best Paratha", menuItemDto.getDescription());
    }

    @Test
    public void getPriceTest() {
        assertEquals(50, menuItemDto.getPrice());
    }

    @Test
    public void setMenuIdTest() {
        String newValue = "0e496f90-5566-42ce-b354-d1cedc73197d";
        menuItemDto.setMenuId(newValue);
        assertEquals(newValue, menuItemDto.getMenuId());
    }

    @Test
    public void setMenuItemIdTest() {
        String newValue = "99496f90-5566-42ce-b354-d1cedc73197d";
        menuItemDto.setMenuItemId(newValue);
        assertEquals(newValue, menuItemDto.getMenuItemId());
    }

    @Test
    public void setNameTest() {
        String newValue = "Khichadi";
        menuItemDto.setName(newValue);
        assertEquals(newValue, menuItemDto.getName());
    }

    @Test
    public void setDescriptionTest() {
        String newValue = "Best Khichadi";
        menuItemDto.setDescription(newValue);
        assertEquals(newValue, menuItemDto.getDescription());
    }

    @Test
    public void setPriceTest() {
        int newValue = 10;
        menuItemDto.setPrice(newValue);
        assertEquals(newValue, menuItemDto.getPrice());
    }
}
