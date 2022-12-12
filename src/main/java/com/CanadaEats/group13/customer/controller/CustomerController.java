package com.CanadaEats.group13.customer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.customer.business.CustomerPageHelpers;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.model.request.MenuRequestModel;
import com.CanadaEats.group13.restaurantowner.repository.IRestaurantOwnerRepository;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;

@Controller
public class CustomerController {

    IUserBusiness userBusiness;
    IRestaurantBusiness restaurantBusiness;
    IRestaurantOwnerBusiness restaurantOwnerBusiness;
    IRestaurantOwnerRepository repository;

    public CustomerController() {
        this.userBusiness = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));
        this.restaurantBusiness = new RestaurantBusiness(new RestaurantRepository(DatabaseConnection.getInstance()));
        this.restaurantOwnerBusiness = new RestaurantOwnerBusiness(
                new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
        this.repository = new RestaurantOwnerRepository(DatabaseConnection.getInstance());
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
    public String showRestaurant(@PathVariable("restaurantId") String restaurantId, Model model,
            RedirectAttributes redirectAttrs) {

        RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
        String id = restaurantDTO.getRestaurantId();
        model.addAttribute("restaurant", restaurantDTO);

        List<List<MenuItemDto>> menuItems = CustomerPageHelpers.getMenuItems(id);
        model.addAttribute("menuItems", menuItems);

        return "customer/restaurantDisplayPage";
    }

    @GetMapping("/customer/menuItems/{restaurantId}/{id}/search")
    public String searchMenuItems(@PathVariable("restaurantId") String restaurantId, @PathVariable("id") int id,
            @RequestParam("query") String query, Model model) {

        RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);

        model.addAttribute("restaurant", restaurantDTO);

        List<List<MenuItemDto>> menuItemsResult = CustomerPageHelpers.getMenuItems(restaurantId);
        List<List<MenuItemDto>> menuItems = CustomerPageHelpers.searchMenuItems(menuItemsResult, query);

        model.addAttribute("menuItems", menuItems);

        return "customer/restaurantDisplayPage";
    }

    @GetMapping("/addtocart/{menuId}/{menuItemId}/")
    public String addItemsToCart(@PathVariable("menuId") String menuId, @PathVariable("menuItemId") String menuItemId,
            Model model, RedirectAttributes redirectAttrs) {

        MenuItemDto menuItemDto = repository.getMenuItem(menuItemId);
        Map<String, int[]> cartItems = CustomerPageHelpers.addItemsToCart(menuItemDto);

        model.addAttribute("cartItems", cartItems);

        MenuRequestModel menuRequestModel = repository.getMenu(menuId);
        String restaurantId = menuRequestModel.getRestaurantId();

        RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
        String id = restaurantDTO.getRestaurantId();
        model.addAttribute("restaurant", restaurantDTO);

        List<List<MenuItemDto>> menuItems = CustomerPageHelpers.getMenuItems(id);
        model.addAttribute("menuItems", menuItems);

        return "customer/restaurantDisplayPage";
    }

    @GetMapping("/checkout/")
    public String checkoutCart(Model model) {

        HashMap<String, int[]> cartItems = CustomerPageHelpers.getCartItems();
        model.addAttribute("cartItems", cartItems);
        List<int[]> cartlist = new ArrayList<int[]>(cartItems.values());
        List<String> keys = new ArrayList<>(cartItems.keySet());
        model.addAttribute("keys", keys);
        model.addAttribute("cartList", cartlist);
        return "customer/checkoutPage";
    }

    @GetMapping("/payment")
    public String makePayment(Model model){
        int gradTotal=CustomerPageHelpers.getGrandTotal();
        model.addAttribute("grandTotal",gradTotal);
        return "payment/payment";
    }

    @GetMapping("/successPayment")
    public String confirmPayment(Model model){
        return "payment/successPayment";
    }

}
