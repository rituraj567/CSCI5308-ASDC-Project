package com.CanadaEats.group13.common;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.customer.dto.RatingDto;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;

public interface IDTOFactory {
    public UserDetailsDto createUserDetailsDto();

    public UserLoginDto createUserLoginDto();

    public RestaurantDTO createRestaurantDTO();

    public RestaurantOwnerDto createRestaurantOwnerDto();

    public MenuItemDto createMenuItemDto();

    public FilterDto createFiltersDto();

    public MenuDto createMenuDto();

    public RatingDto createRatingDto();
}
