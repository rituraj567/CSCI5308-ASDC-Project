package com.CanadaEats.group13.authentication.business;

import java.util.UUID;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;
import com.CanadaEats.group13.authentication.repository.IUserRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;

public class UserBusiness implements IUserBusiness {

    IUserRepository userRepository;

    public UserBusiness(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetailsResponseModel registerUser(UserDetailsDto userDto) {
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();
        boolean isValidUser = validateRegisterUser(userDto);
        if (isValidUser) {
            try {
                String encryptedPassword = PasswordEncoderDecoder.getInstance().encrypt(userDto.getPassword());
                userDto.setPassword(encryptedPassword);
            } catch (Exception ex) {
                System.out.println("Exception: In Password Encoding In User Registration");
            }

            UUID uuid = UUID.randomUUID();
            userDto.setUserId(uuid.toString());
            userDto.setStatus(ApplicationConstants.ACTIVE_STATUS);
            userDto.setRoleId(ApplicationConstants.CUSTOMER_ROLEID);

            userResponse = userRepository.registerUser(userDto);
        }

        return userResponse;
    }

    public UserLoginResponseModel loginUser(UserLoginDto userLoginDto) {
        UserLoginResponseModel response = null;
        String userName = userLoginDto.getUserName();
        String password = userLoginDto.getPassword();

        if (userName == null || password == null) {
            return response;
        }

        response = userRepository.loginUser(userLoginDto);
        return response;
    }

    @Override
    public UserDetailsDto getUserDetails(String id) {
        return userRepository.getUserDetails(id);
    }

    @Override
    public void updateUserProfile(UserDetailsDto userDetailsDto) {
        userRepository.updateUserProfile(userDetailsDto);
    }

    public boolean validateRegisterUser(UserDetailsDto userDto) {
        boolean isValid = true;
        if (userDto.getFirstName() == null || userDto.getFirstName().length() == 0) {
            isValid = false;
        } else if (userDto.getLastName() == null || userDto.getLastName().length() == 0) {
            isValid = false;
        } else if (userDto.getUserName() == null || userDto.getUserName().length() == 0) {
            isValid = false;
        } else if (userDto.getEmailId() == null || userDto.getEmailId().length() == 0) {
            isValid = false;
        } else if (userDto.getPassword() == null || userDto.getPassword().length() == 0) {
            isValid = false;
        } else if (userDto.getAddress() == null || userDto.getAddress().length() == 0) {
            isValid = false;
        } else if (userDto.getGender() == null || userDto.getGender().length() == 0) {
            isValid = false;
        } else if (userDto.getCity() == null || userDto.getCity().length() == 0) {
            isValid = false;
        } else if (userDto.getProvince() == null || userDto.getProvince().length() == 0) {
            isValid = false;
        } else if (userDto.getPostalCode() == null || userDto.getPostalCode().length() == 0) {
            isValid = false;
        } else if (userDto.getCountry() == null || userDto.getCountry().length() == 0) {
            isValid = false;
        }

        return isValid;
    }
}
