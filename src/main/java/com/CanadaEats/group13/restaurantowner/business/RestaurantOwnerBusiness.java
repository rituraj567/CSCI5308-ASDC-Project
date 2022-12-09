package com.CanadaEats.group13.restaurantowner.business;


import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.IRestaurantOwnerRepository;
import java.util.ArrayList;
import java.util.List;

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
}
