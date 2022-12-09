package com.CanadaEats.group13.restaurantowner.business;


import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.model.request.MenuRequestModel;
import com.CanadaEats.group13.restaurantowner.repository.IRestaurantOwnerRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestaurantOwnerBusiness implements IRestaurantOwnerBusiness {

    IRestaurantOwnerRepository userRepository;

    public RestaurantOwnerBusiness(IRestaurantOwnerRepository userRepository)
    {
       this.userRepository = userRepository;
    }

    @Override
    public List<RestaurantOwnerDto> getAllMenus(String restaurantId){
        List<RestaurantOwnerDto> userResponse = new ArrayList<>();

        try
        {
            userResponse = userRepository.getAllMenus(restaurantId);
        }
        catch (Exception ex)
        {
            System.out.println("Exception: getAllMenus in RestaurantOwnerBusiness");
        }


        return userResponse;
    }

    @Override
    public boolean addMenu(String restaurantId, MenuDto menuDto) {
        MenuRequestModel menuRequestModel = new MenuRequestModel();
        UUID uuid = UUID.randomUUID();
        menuRequestModel.setMenuId(uuid.toString());
        menuRequestModel.setStatus(ApplicationConstants.ACTIVE_STATUS);
        menuRequestModel.setName(menuDto.getMenuName());
        menuRequestModel.setRestaurantId(restaurantId);
        boolean result = userRepository.addMenu(menuRequestModel);
        return result;
    }
}
