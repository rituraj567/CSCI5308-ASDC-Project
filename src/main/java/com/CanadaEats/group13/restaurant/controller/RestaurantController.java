package com.CanadaEats.group13.restaurant.controller;

import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping("/restaurants")
    public String displayRestaurants(Model model) {
        List<RestaurantDTO> restaurants = restaurantRepository.getAllRestaurants();

        model.addAttribute("restaurants", restaurants);

        return "/restaurants/restaurant";
    }

 
    @GetMapping("/admin/restaurants/newRestaurant")
    public String newRestuarantForm(Model model){

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        model.addAttribute("restaurant", restaurantDTO);
        
        return "restaurants/newRestuarant";
    }

    @GetMapping("/admin/restaurants/{resturantId}/edit")
    public String editRestuarants(@PathVariable("resturantId") int restaurantId,Model model){

        RestaurantDTO restaurantDTO =  restaurantRepository.getRestaurantById(restaurantId);
       
        model.addAttribute("restaurant", restaurantDTO);
        
        return "restaurants/editRestaurant";
    }


    @PostMapping("/admin/restaurants/")
    public String createRestaurant(@ModelAttribute RestaurantDTO restaurantDTO){

        restaurantRepository.postRestaurant(restaurantDTO);
        
        return "redirect:/restaurants";
    }

    @PostMapping("/admin/restaurants/{restaurantId}")
    public String updateRestaurant(@PathVariable("restaurantId") int restaurantId, @ModelAttribute("restaurant") RestaurantDTO restaurantDTO,Model model){
        model.addAttribute("restaurant",restaurantDTO);
        restaurantDTO.setId(restaurantId);
        restaurantRepository.updateRestuarant(restaurantDTO);

        return "redirect:/restaurants";
    }

}
