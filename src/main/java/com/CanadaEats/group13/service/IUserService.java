package com.CanadaEats.group13.service;

import com.CanadaEats.group13.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.shared.dto.UserDetailsDto;

public interface IUserService {
    UserDetailsResponseModel registerUser(UserDetailsDto userDto);
}
