package com.CanadaEats.group13.customer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.customer.business.CustomerBusinness;
import com.CanadaEats.group13.customer.business.ICustomerBusiness;
import com.CanadaEats.group13.customer.repository.CustomerRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;

@Controller
public class CustomerController {

    ICustomerBusiness customerBusiness;
    IUserBusiness userBusiness;
    IRestaurantBusiness restaurantBusiness;

    public CustomerController() {
        this.customerBusiness = new CustomerBusinness(new CustomerRepository(DatabaseConnection.getInstance()));
        this.userBusiness = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));
        this.restaurantBusiness = new RestaurantBusiness(new RestaurantRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/userHomePage")
    public String displayHomePage(Model model, HttpServletRequest request) {

        List<RestaurantDTO> restaurantDTOList = restaurantBusiness.getAllRestaurants();
        model.addAttribute("restaurants", restaurantDTOList);

        return "customer/customerHomePage";

    }

    @GetMapping("/customer/restaurants/search")
    public String searchRestaurants(@RequestParam("query") String query, Model model) {
        List<RestaurantDTO> restaurantDTOList = restaurantBusiness.searchRestaurants(query);
        model.addAttribute("restaurants", restaurantDTOList);
        return "customer/customerHomePage";
    }

    @GetMapping("/restaurant/{restaurantId}/display")
    public String showRestaurant(@PathVariable("restaurantId") int restaurantId, Model model) {

        RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
        model.addAttribute("restaurant", restaurantDTO);
        return "customer/restaurantDisplayPage";
    }

}
