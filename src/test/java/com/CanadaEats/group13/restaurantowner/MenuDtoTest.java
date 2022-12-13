package com.CanadaEats.group13.restaurantowner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurantowner.dto.MenuDto;

public class MenuDtoTest {
    MenuDto menuDto;

    @BeforeEach
    public void testSetup() {
        menuDto = new MenuDto("0e496f90-5566-42ce-b354-d1cedc73197d", "Punjabi");
    }

    @Test
    public void getMenuIdTest() {
        assertEquals("0e496f90-5566-42ce-b354-d1cedc73197d", menuDto.getMenuId());
    }

    @Test
    public void getMenuNameTest() {
        assertEquals("Punjabi", menuDto.getMenuName());
    }

    @Test
    public void setMenuIdTest() {
        String newValue = "0e496f90-5566-42ce-b354-d1cedc73197d";
        menuDto.setMenuId(newValue);
        assertEquals(newValue, menuDto.getMenuId());
    }

    @Test
    public void setMenuNameTest() {
        String newValue = "Gujarati";
        menuDto.setMenuName(newValue);
        assertEquals(newValue, menuDto.getMenuName());
    }
}
