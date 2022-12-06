package com.CanadaEats.group13.authentication.controller;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.utils.ApplicationConstants;
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
    public String userRegistrationErrorPage(Model model){
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        model.addAttribute("userregistration", userDetailsDto);
        return "authentication/registerUser";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDetailsDto userDetailsDto)
    {
        UserDetailsResponseModel userResponse = userService.registerUser(userDetailsDto);
        if(userResponse.getUserId() == null)
        {
            return "redirect:/userregistrationerrorpage";
        }
        else
        {
            System.out.println("Success");
            return "redirect:/userloginpage";
        }
    }

    @GetMapping("/userregistrationerrorpage")
    public String userRegistrationForm(Model model){
        String errorMessage = "Some error occured, Please, try again";
        model.addAttribute("errorMessageRegistration", errorMessage);
        return "authentication/registerUserError";
    }

    @GetMapping("/userloginpage")
    public String userLoginForm(Model model){
        UserLoginDto userLoginDto = new UserLoginDto();
        model.addAttribute("userlogin", userLoginDto);
        return "authentication/loginUser";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserLoginDto userLoginDto)
    {
        String userResponse = userService.loginUser(userLoginDto);

        if(userResponse.equals(ApplicationConstants.ADMIN_ROLEID))
        {
            //redirect on admin home page
            System.out.println("ADMIN ROLE USER");
            return "redirect:/restaurants";
        }
        else if (userResponse.equals(ApplicationConstants.RESTAURANT_OWNER_ROLEID))
        {
            //redirect on restaurant owner home page
            System.out.println("RESTAUEANT OWNER ROLE USER");
            return "redirect:/userloginpage";
        }
        else if(userResponse.equals(ApplicationConstants.CUSTOMER_ROLEID))
        {
            //redirect on customer home page
            System.out.println("CUSTOMER ROLE USER");
            return "redirect:/userloginpage";
        }
        else if (userResponse.equals(ApplicationConstants.DELIVERY_PERSON_ROLEID))
        {
            //redirect on delivery person home page
            System.out.println("DELIVERY PERSON ROLE USER");
            return "redirect:/userloginpage";
        }
        else{
            //redirect on error page
            return "redirect:/userloginerrorpage";
        }
    }

    @GetMapping("/userloginerrorpage")
    public String userLoginErrorPage(Model model){
        String errorMessage = "Some error occured, Please, try again";
        model.addAttribute("errorMessageLogin", errorMessage);
        return "authentication/loginUserError";
    }

    @GetMapping("/logout")
    public String userLogout(Model model){
        return "redirect:/userloginpage";
    }
}
