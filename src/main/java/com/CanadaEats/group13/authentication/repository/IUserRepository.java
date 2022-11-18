package com.CanadaEats.group13.authentication.repository;

import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public interface IUserRepository{
    public UserDetailsResponseModel registerUser(UserDetailsDto userDetails);
}
