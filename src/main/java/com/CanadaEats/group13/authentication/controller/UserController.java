package com.CanadaEats.group13.authentication.controller;

import com.CanadaEats.group13.authentication.model.request.UserDetailsRequestModel;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.service.UserService;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser()
    {
        return "get user";
    }

    @PostMapping
    public UserDetailsResponseModel registerUser(@RequestBody UserDetailsRequestModel userDetails)
    {
        UserDetailsDto userDto = new UserDetailsDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDetailsResponseModel userResponse = userService.registerUser(userDto);

        return userResponse;
    }
}
