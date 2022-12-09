package com.CanadaEats.group13.restaurantOwnerAdmin.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurantOwnerAdmin.dto.RestaurantOwnerAdminDto;
import com.CanadaEats.group13.restaurantOwnerAdmin.repository.IRestaurantOwnerAdminRepository;
import com.CanadaEats.group13.restaurantOwnerAdmin.repository.RestaurantOwnerAdminRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RestaurantOwnerAdminController {
    IRestaurantOwnerAdminRepository restaurantOwnerAdminRepository;

    public RestaurantOwnerAdminController(){
        this.restaurantOwnerAdminRepository= new RestaurantOwnerAdminRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/restaurantOwners")
    public String displayRestaurantOwners(Model model) {
        List<RestaurantOwnerAdminDto> restaurantOwners = restaurantOwnerAdminRepository.getAllRestaurantOwners();
        System.out.println(restaurantOwners.get(1));
        model.addAttribute("restaurantOwners", restaurantOwners);
        return "/restaurantOwnersAdmin/viewRestaurantOwner";
    }

    @GetMapping("/admin/restaurantOwners/newRestaurantOwner")
    public String newRestuarantOwnerForm(Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = new RestaurantOwnerAdminDto();
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/newRestaurantOwner";
    }

    @PostMapping("/admin/restaurantOwners/")
    public String createRestaurant(@ModelAttribute RestaurantOwnerAdminDto restaurantOwnerAdminDto) {
        restaurantOwnerAdminRepository.postRestaurantOwnerAdmin(restaurantOwnerAdminDto);
        return "redirect:/restaurantOwners";
    }


}
