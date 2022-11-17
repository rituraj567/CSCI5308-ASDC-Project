package com.CanadaEats.group13.authentication.service;

import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public interface IUserService {
    UserDetailsResponseModel registerUser(UserDetailsDto userDto);
}
