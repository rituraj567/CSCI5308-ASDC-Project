package com.CanadaEats.group13.restaurantOwnersAdmin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.repository.IRestaurantOwnerAdminRepository;
import com.CanadaEats.group13.restaurantOwnersAdmin.repository.RestaurantOwnerAdminRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class RestaurantOwnerAdminController {
    IRestaurantOwnerAdminRepository restaurantOwnerAdminRepository;

    public RestaurantOwnerAdminController() {
        this.restaurantOwnerAdminRepository = new RestaurantOwnerAdminRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/restaurantOwners")
    public String displayRestaurantOwners(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<RestaurantOwnerAdminDto> restaurantOwners = restaurantOwnerAdminRepository.getAllRestaurantOwners();
            model.addAttribute("restaurantOwners", restaurantOwners);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_HOMEPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurantsOwnerAdmin/newRestaurantOwnerAdmin")
    public String newRestaurantOwnerForm(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantOwnerAdminDto restaurantOwnerAdminDto = new RestaurantOwnerAdminDto();
            model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_NEW;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/admin/restaurantsOwnerAdmin/")
    public String createRestaurantOwner(@ModelAttribute RestaurantOwnerAdminDto restaurantOwnerAdminDto,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantOwnerAdminRepository.postRestaurantOwnerAdmin(restaurantOwnerAdminDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_POST_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurantOwners/{userId}/edit")
    public String editRestaurantOwner(@PathVariable("userId") int userId, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(userId);
            model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_EDIT;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/admin/restaurantOwners/{userId}")
    public String updateRestaurantOwner(@PathVariable("userId") int userId,
            @ModelAttribute("restaurantOwner") RestaurantOwnerAdminDto restaurantOwnerAdminDto, Model model,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            model.addAttribute("restaurant", restaurantOwnerAdminDto);
            restaurantOwnerAdminDto.setId(userId);
            restaurantOwnerAdminRepository.updateRestaurantOwner(restaurantOwnerAdminDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_POST_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurantOwners/{userId}/delete")
    public String deleteRestaurantOwner(@PathVariable("userId") int userId, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantOwnerAdminRepository.deleteRestaurantOwner(userId);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_DELETE_SUCCESS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/admin/restaurantOwners/{userId}/view")
    public String viewRestaurantOwner(@PathVariable("userId") int userId, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(userId);
            model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_VIEW;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/bindRestaurantOwner")
    public String bindRestaurantOwner(@RequestBody RestaurantBindingDto restaurantBindingDto,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantOwnerAdminRepository.bindRestaurantOwner(restaurantBindingDto);
            return ApplicationConstants.URL_RESTAURANTOWNERADMIN_BIND;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

}
