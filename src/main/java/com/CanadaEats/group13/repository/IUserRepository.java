package com.CanadaEats.group13.repository;

import com.CanadaEats.group13.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.shared.dto.UserDetailsDto;

public interface IUserRepository{
    public UserDetailsResponseModel registerUser(UserDetailsDto userDetails);
}
