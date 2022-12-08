package com.CanadaEats.group13.authentication.business;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;
import com.CanadaEats.group13.authentication.repository.IUserRepository;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;

import java.util.UUID;

public class UserBusiness implements IUserBusiness {

    IUserRepository userRepository;

    public UserBusiness(IUserRepository userRepository)
    {
       this.userRepository = userRepository;
    }

    @Override
    public UserDetailsResponseModel registerUser(UserDetailsDto userDto){
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();

        try
        {
            PasswordEncoderDecoder passwordEncoderDecoder = new PasswordEncoderDecoder();
            String encryptedPassword = passwordEncoderDecoder.encrypt(userDto.getPassword());
            userDto.setPassword(encryptedPassword);
        }
        catch (Exception ex)
        {
            System.out.println("Exception: In Password Encoding In User Registration");
        }

        UUID uuid = UUID.randomUUID();
        userDto.setUserId(uuid.toString());
        userDto.setStatus(ApplicationConstants.ACTIVE_STATUS);
        userDto.setRoleId(ApplicationConstants.CUSTOMER_ROLEID);

        userResponse = userRepository.registerUser(userDto);

        return userResponse;
    }

    public UserLoginResponseModel loginUser(UserLoginDto userLoginDto){
        UserLoginResponseModel response = null;
        String userName = userLoginDto.getUserName();
        String password = userLoginDto.getPassword();

        if(userName == null || password == null)
        {
            return response;
        }

        response = userRepository.loginUser(userLoginDto);
        return response;
    }
}
