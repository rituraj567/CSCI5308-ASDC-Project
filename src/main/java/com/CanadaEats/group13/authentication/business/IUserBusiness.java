package com.CanadaEats.group13.authentication.business;

import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public interface IUserBusiness {
    UserDetailsResponseModel registerUser(UserDetailsDto userDto) throws Exception;
}
