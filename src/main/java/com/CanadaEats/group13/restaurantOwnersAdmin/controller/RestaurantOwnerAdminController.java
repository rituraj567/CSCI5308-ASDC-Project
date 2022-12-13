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

@Controller
public class RestaurantOwnerAdminController {
    IRestaurantOwnerAdminRepository restaurantOwnerAdminRepository;

    public RestaurantOwnerAdminController() {
        this.restaurantOwnerAdminRepository = new RestaurantOwnerAdminRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/restaurantOwners")
    public String displayRestaurantOwners(Model model) {
        List<RestaurantOwnerAdminDto> restaurantOwners = restaurantOwnerAdminRepository.getAllRestaurantOwners();
        model.addAttribute("restaurantOwners", restaurantOwners);
        return "restaurantOwnersAdmin/restaurantOwnerAdmin";
    }

    @GetMapping("/admin/restaurantsOwnerAdmin/newRestaurantOwnerAdmin")
    public String newRestaurantOwnerForm(Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = new RestaurantOwnerAdminDto();
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/newRestaurantOwnerAdmin";
    }

    @PostMapping("/admin/restaurantsOwnerAdmin/")
    public String createRestaurantOwner(@ModelAttribute RestaurantOwnerAdminDto restaurantOwnerAdminDto) {
        restaurantOwnerAdminRepository.postRestaurantOwnerAdmin(restaurantOwnerAdminDto);
        return "redirect:/restaurantOwners";
    }

    @GetMapping("/admin/restaurantOwners/{UserId}/edit")
    public String editRestaurantOwner(@PathVariable("UserId") int UserId, Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(UserId);
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/editRestaurantOwner";
    }

    @PostMapping("/admin/restaurantOwners/{UserId}")
    public String updateRestaurantOwner(@PathVariable("UserId") int restaurantId,
            @ModelAttribute("restaurantOwner") RestaurantOwnerAdminDto restaurantOwnerAdminDto, Model model) {
        model.addAttribute("restaurant", restaurantOwnerAdminDto);
        restaurantOwnerAdminDto.setId(restaurantId);
        restaurantOwnerAdminRepository.updateRestaurantOwner(restaurantOwnerAdminDto);
        return "redirect:/restaurantOwners";
    }

    @GetMapping("/admin/restaurantOwners/{UserId}/delete")
    public String deleteRestaurantOwner(@PathVariable("UserId") int UserId) {
        restaurantOwnerAdminRepository.deleteRestaurantOwner(UserId);
        return "redirect:/restaurantOwners";
    }

    @GetMapping("/admin/restaurantOwners/{UserId}/view")
    public String viewRestaurantOwner(@PathVariable("UserId") int UserId, Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(UserId);
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/viewRestaurantOwnerAdmin";
    }

    @PostMapping("/bindRestaurantOwner")
    public String updateFilters(@RequestBody RestaurantBindingDto restaurantBindingDto, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantOwnerAdminRepository.bindRestaurantOwner(restaurantBindingDto);
            return "redirect:/filters";
        }
        return "redirect:/userloginpage";
    }

}
