package com.CanadaEats.group13.authentication.business;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;

public interface IUserBusiness {
    UserDetailsResponseModel registerUser(UserDetailsDto userDto);

    UserLoginResponseModel loginUser(UserLoginDto userLoginDto);

    public UserDetailsDto getUserDetails(String id);

    public void updateUserProfile(UserDetailsDto userDetailsDto);
}
