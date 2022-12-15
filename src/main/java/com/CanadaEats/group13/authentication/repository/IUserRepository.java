package com.CanadaEats.group13.authentication.repository;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;

public interface IUserRepository {
    UserDetailsResponseModel registerUser(UserDetailsDto userDetails);

    UserLoginResponseModel loginUser(UserLoginDto userLoginDto);

    public UserDetailsDto getUserDetails(String id);

    public void updateUserProfile(UserDetailsDto userDetails);
}
