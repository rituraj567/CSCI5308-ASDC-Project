package com.CanadaEats.group13.restaurant.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.IRestaurantRepository;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;

@Controller
public class RestaurantController {

    IRestaurantRepository restaurantRepository;

    public RestaurantController() {
        this.restaurantRepository = new RestaurantRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/restaurants")
    public String displayRestaurants(Model model) {
        List<RestaurantDTO> restaurants = restaurantRepository.getAllRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "/restaurants/restaurant";
    }

    @GetMapping("/admin/restaurants/newRestaurant")
    public String newRestuarantForm(Model model) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        model.addAttribute("restaurant", restaurantDTO);
        return "restaurants/newRestuarant";
    }

    @GetMapping("/admin/restaurants/{resturantId}/edit")
    public String editRestuarants(@PathVariable("resturantId") int restaurantId, Model model) {
        RestaurantDTO restaurantDTO = restaurantRepository.getRestaurantById(restaurantId);
        model.addAttribute("restaurant", restaurantDTO);
        return "restaurants/editRestaurant";
    }

    @GetMapping("/admin/restaurants/{restaurantId}/delete")
    public String deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantRepository.deleteRestaurant(restaurantId);
        return "redirect:/restaurants";
    }

    @GetMapping("/admin/restaurants/{restaurantId}/view")
    public String viewRestaurant(@PathVariable("restaurantId") int restaurantId, Model model) {
        RestaurantDTO restaurantDTO = restaurantRepository.getRestaurantById(restaurantId);
        model.addAttribute("restaurant", restaurantDTO);
        return "restaurants/viewRestaurant";
    }

    @GetMapping("/restaurants/search")
    public String searchRestaurants(@RequestParam("query") String query, Model model) {
        List<RestaurantDTO> restaurantDTOList = restaurantRepository.searchRestaurants(query);
        model.addAttribute("restaurants", restaurantDTOList);
        return "restaurants/restaurant";
    }

    @PostMapping("/admin/restaurants/")
    public String createRestaurant(@ModelAttribute RestaurantDTO restaurantDTO) {
        restaurantRepository.postRestaurant(restaurantDTO);
        return "redirect:/restaurants";
    }

    @PostMapping("/admin/restaurants/{restaurantId}")
    public String updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @ModelAttribute("restaurant") RestaurantDTO restaurantDTO, Model model) {
        model.addAttribute("restaurant", restaurantDTO);
        restaurantDTO.setId(restaurantId);
        restaurantRepository.updateRestuarant(restaurantDTO);
        return "redirect:/restaurants";
    }

}
