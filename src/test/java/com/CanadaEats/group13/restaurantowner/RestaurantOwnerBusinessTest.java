package com.CanadaEats.group13.restaurantowner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;

public class RestaurantOwnerBusinessTest {
    @InjectMocks
    RestaurantOwnerBusiness restaurantOwnerBusiness;

    @Mock
    RestaurantOwnerRepository restaurantOwnerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void getAllMenusSuccessTest() {
        List<RestaurantOwnerDto> userResponse = prepareGetAllMenusData();
        when(restaurantOwnerRepository.getAllMenus(anyString())).thenReturn(userResponse);

        List<RestaurantOwnerDto> result = restaurantOwnerBusiness.getAllMenus("");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(userResponse.get(0).getName(), result.get(0).getName());
    }

    @Test
    final void getAllMenusFailureTest() {
        List<RestaurantOwnerDto> userResponse = prepareGetAllMenusData();
        when(restaurantOwnerRepository.getAllMenus(anyString())).thenReturn(userResponse);

        List<RestaurantOwnerDto> result = restaurantOwnerBusiness.getAllMenus("");

        assertNotNull(result);
        assertNotEquals(userResponse.get(1).getName(), result.get(0).getName());
    }

    @Test
    final void addMenuSuccessTest() {
        MenuDto menuDto = DTOFactory.getInstance().createMenuDto();
        menuDto.setMenuName("Punjabi");
        when(restaurantOwnerRepository.addMenu(any())).thenReturn(true);

        boolean result = restaurantOwnerBusiness.addMenu("d0ac2c3e-4713-4a21-8f65-4aec10cab89e", menuDto);

        assertTrue(result);
    }

    @Test
    final void addMenuFailureTest() {
        MenuDto menuDto = DTOFactory.getInstance().createMenuDto();
        menuDto.setMenuName("Gujarati");
        when(restaurantOwnerRepository.addMenu(any())).thenReturn(false);

        boolean result = restaurantOwnerBusiness.addMenu("d0ac2c3e-4713-4a21-8f65-4aec10cab89e", menuDto);

        assertFalse(result);
    }

    @Test
    final void addMenuItemSuccessTest() {
        MenuItemDto menuItemDto = DTOFactory.getInstance().createMenuItemDto();
        menuItemDto.setName("Roti");
        menuItemDto.setDescription("Best Roti");
        menuItemDto.setPrice(10);
        when(restaurantOwnerRepository.addMenuItem(any())).thenReturn(true);

        boolean result = restaurantOwnerBusiness.addMenuItem("0e496f90-5566-42ce-b354-d1cedc73197e", menuItemDto);

        assertTrue(result);
    }

    @Test
    final void addMenuItemFailureTest() {
        MenuItemDto menuItemDto = DTOFactory.getInstance().createMenuItemDto();
        menuItemDto.setName("Roti");
        menuItemDto.setDescription("Best Roti");
        menuItemDto.setPrice(10);
        when(restaurantOwnerRepository.addMenuItem(any())).thenReturn(false);

        boolean result = restaurantOwnerBusiness.addMenuItem("0e496f90-5566-42ce-b354-d1cedc73197e", menuItemDto);

        assertFalse(result);
    }

    @Test
    final void getMenuItemsSuccessTest() {
        List<MenuItemDto> menuItemDtos = prepareGetAllMenuItemsData();
        when(restaurantOwnerRepository.getMenuItems(anyString())).thenReturn(menuItemDtos);

        List<MenuItemDto> result = restaurantOwnerBusiness.getMenuItems("");

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(menuItemDtos.get(0).getName(), result.get(0).getName());
    }

    @Test
    final void getMenuItemsFailureTest() {
        List<MenuItemDto> menuItemDtos = prepareGetAllMenuItemsData();
        when(restaurantOwnerRepository.getMenuItems(anyString())).thenReturn(menuItemDtos);

        List<MenuItemDto> result = restaurantOwnerBusiness.getMenuItems("");

        assertNotNull(result);
        assertNotEquals(menuItemDtos.get(1).getName(), result.get(0).getName());
    }

    @Test
    final void deleteMenuSuccessTest(){
        when(restaurantOwnerRepository.deleteMenu(anyString())).thenReturn(true);

        boolean result = restaurantOwnerBusiness.deleteMenu("");

        assertTrue(result);
    }

    @Test
    final void deleteMenuFailureTest(){
        when(restaurantOwnerRepository.deleteMenu(anyString())).thenReturn(false);

        boolean result = restaurantOwnerBusiness.deleteMenu("");

        assertFalse(result);
    }

    private List<RestaurantOwnerDto> prepareGetAllMenusData() {
        List<RestaurantOwnerDto> restaurantOwnerDtos = new ArrayList<>();

        RestaurantOwnerDto element1 = DTOFactory.getInstance().createRestaurantOwnerDto();
        element1.setRestaurantName("Subway");
        element1.setRestaurantId("d0ac2c3e-4713-4a21-8f65-4aec10cab89e");
        element1.setName("Punjabi");
        restaurantOwnerDtos.add(element1);

        RestaurantOwnerDto element2 = DTOFactory.getInstance().createRestaurantOwnerDto();
        element2.setRestaurantName("Subway");
        element2.setRestaurantId("d0ac2c3e-4713-4a21-8f65-4aec10cab89e");
        element2.setName("Gujarati");
        restaurantOwnerDtos.add(element2);

        return restaurantOwnerDtos;
    }

    private List<MenuItemDto> prepareGetAllMenuItemsData() {
        List<MenuItemDto> menuItemDtos = new ArrayList<>();

        MenuItemDto element1 = DTOFactory.getInstance().createMenuItemDto();
        element1.setName("Roti");
        element1.setDescription("Best Roti");
        element1.setPrice(10);
        menuItemDtos.add(element1);

        MenuItemDto element2 = DTOFactory.getInstance().createMenuItemDto();
        element2.setName("Khichadi");
        element2.setDescription("Best Khichadi");
        element2.setPrice(15);
        menuItemDtos.add(element2);

        return menuItemDtos;
    }
}
