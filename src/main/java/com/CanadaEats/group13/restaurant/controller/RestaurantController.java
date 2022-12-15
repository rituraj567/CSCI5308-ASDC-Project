package com.CanadaEats.group13.restaurant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class RestaurantController {

    IRestaurantBusiness restaurantBusiness;

    public RestaurantController() {

        this.restaurantBusiness = new RestaurantBusiness(new RestaurantRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/restaurants")
    public String displayRestaurants(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<RestaurantDTO> restaurants = restaurantBusiness.getAllRestaurants();

            model.addAttribute("restaurants", restaurants);

            return ApplicationConstants.URL_RESTAURANT_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurants/newRestaurant")
    public String newRestuarantForm(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantDTO restaurantDTO = DTOFactory.getInstance().createRestaurantDTO();
            model.addAttribute("restaurant", restaurantDTO);

            return ApplicationConstants.URL_RESTAURANT_CREATION;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurants/{resturantId}/edit")
    public String editRestuarants(@PathVariable("resturantId") String restaurantId, Model model,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);

            model.addAttribute("restaurant", restaurantDTO);

            return ApplicationConstants.URL_RESTAURANT_EDIT_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurants/{restaurantId}/delete")
    public String deleteRestaurant(@PathVariable("restaurantId") String restaurantId, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantBusiness.deleteRestaurant(restaurantId);
            return ApplicationConstants.URL_RESTAURANTS_DELETE_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurants/{restaurantId}/view")
    public String viewRestaurant(@PathVariable("restaurantId") String restaurantId, Model model,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
            model.addAttribute("restaurant", restaurantDTO);
            return ApplicationConstants.URL_RESTAURANTS_VIEW_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/restaurants/search")
    public String searchRestaurants(@RequestParam("query") String query, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<RestaurantDTO> restaurantDTOList = restaurantBusiness.searchRestaurants(query);
            model.addAttribute("restaurants", restaurantDTOList);
            return ApplicationConstants.URL_RESTAURANTS_SEARCH_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/admin/restaurants/")
    public String createRestaurant(@ModelAttribute RestaurantDTO restaurantDTO, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantBusiness.insertRestaurant(restaurantDTO);

            return ApplicationConstants.URL_RESTAURANT_POST_CREATION;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/admin/restaurants/{restaurantId}")
    public String updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @ModelAttribute("restaurant") RestaurantDTO restaurantDTO, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            model.addAttribute("restaurant", restaurantDTO);
            restaurantDTO.setId(restaurantId);
            restaurantBusiness.updateRestuarant(restaurantDTO);

            return ApplicationConstants.URL_RESTAURANT_POST_CREATION;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

}
