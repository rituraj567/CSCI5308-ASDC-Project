package com.CanadaEats.group13.restaurantOwnersAdmin.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantBindingDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;
import com.CanadaEats.group13.restaurantOwnersAdmin.repository.IRestaurantOwnerAdminRepository;
import com.CanadaEats.group13.restaurantOwnersAdmin.repository.RestaurantOwnerAdminRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @GetMapping("/admin/restaurantOwners/{userId}/edit")
    public String editRestaurantOwner(@PathVariable("userId") int userId, Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(userId);
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/editRestaurantOwner";
    }

    @PostMapping("/admin/restaurantOwners/{userId}")
    public String updateRestaurantOwner(@PathVariable("userId") int userId,
                                        @ModelAttribute("restaurantOwner") RestaurantOwnerAdminDto restaurantOwnerAdminDto, Model model) {
        model.addAttribute("restaurant", restaurantOwnerAdminDto);
        restaurantOwnerAdminDto.setId(userId);
        restaurantOwnerAdminRepository.updateRestaurantOwner(restaurantOwnerAdminDto);
        return "redirect:/restaurantOwners";
    }

    @GetMapping("/admin/restaurantOwners/{userId}/delete")
    public String deleteRestaurantOwner(@PathVariable("userId") int userId) {
        restaurantOwnerAdminRepository.deleteRestaurantOwner(userId);
        return "redirect:/restaurantOwners";
    }

    @GetMapping("/admin/restaurantOwners/{userId}/view")
    public String viewRestaurantOwner(@PathVariable("userId") int userId, Model model) {
        RestaurantOwnerAdminDto restaurantOwnerAdminDto = restaurantOwnerAdminRepository.getRestaurantOwner(userId);
        model.addAttribute("restaurantOwner", restaurantOwnerAdminDto);
        return "restaurantOwnersAdmin/viewRestaurantOwnerAdmin";
    }

    @PostMapping("/bindRestaurantOwner")
    public String bindRestaurantOwner(@RequestBody RestaurantBindingDto restaurantBindingDto, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            restaurantOwnerAdminRepository.bindRestaurantOwner(restaurantBindingDto);
            return "redirect:/restaurantOwners";
        }
        return "redirect:/restaurantOwners";
    }

}
