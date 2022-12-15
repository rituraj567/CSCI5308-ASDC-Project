package com.CanadaEats.group13.common;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.customer.dto.RatingDto;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;

public class DTOFactory implements IDTOFactory {

    private static IDTOFactory instance = null;

    private DTOFactory() {

    }

    public static IDTOFactory getInstance() {
        if (instance == null) {
            instance = new DTOFactory();
        }

        return instance;
    }

    @Override
    public UserDetailsDto createUserDetailsDto() {

        return new UserDetailsDto();
    }

    @Override
    public UserLoginDto createUserLoginDto() {

        return new UserLoginDto();
    }

    @Override
    public RestaurantDTO createRestaurantDTO() {

        return new RestaurantDTO();
    }

    @Override
    public RestaurantOwnerDto createRestaurantOwnerDto() {

        return new RestaurantOwnerDto();
    }

    @Override
    public MenuItemDto createMenuItemDto() {

        return new MenuItemDto();
    }

    @Override
    public FilterDto createFiltersDto() {

        return new FilterDto();
    }

    @Override
    public MenuDto createMenuDto() {

        return new MenuDto();
    }

    @Override
    public RatingDto createRatingDto() {
        return new RatingDto();
    }

}
