package com.CanadaEats.group13.authentication.controller;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserBusiness userService;

    @GetMapping
    public String getUser()
    {
        return "get user";
    }

    @GetMapping("/userregistrationpage")
    public String userRegistrationForm(Model model){

        UserDetailsDto userDetailsDto = new UserDetailsDto();
        model.addAttribute("userregistration", userDetailsDto);

        return "authentication/registerUser";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDetailsDto userDetailsDto)
    {
        UserDetailsResponseModel userResponse = userService.registerUser(userDetailsDto);

        //if userresponse has data means success otherwise failure
        if(userResponse.getUserId() == null)
        {
            return "authentication/registerationError";
        }
        else {
            return "redirect:/userloginpage";
        }
    }

    @GetMapping("/userloginpage")
    public String userLoginForm(Model model){

        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userlogin", userLoginDto);

        return "authentication/login";
    }

    @PostMapping("/login")
    public void loginUser()
    {

    }
}
