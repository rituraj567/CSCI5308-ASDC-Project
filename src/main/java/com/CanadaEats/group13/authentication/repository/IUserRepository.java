package com.CanadaEats.group13.authentication.repository;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public interface IUserRepository{
    UserDetailsResponseModel registerUser(UserDetailsDto userDetails);
    String loginUser(UserLoginDto userLoginDto);
}
