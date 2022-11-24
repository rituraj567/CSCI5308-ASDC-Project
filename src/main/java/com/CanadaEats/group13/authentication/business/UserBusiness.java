package com.CanadaEats.group13.authentication.business;

import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserBusiness implements IUserBusiness {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetailsResponseModel registerUser(UserDetailsDto userDto){
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();

        try
        {
            PasswordEncoderDecoder passwordEncoderDecoder = new PasswordEncoderDecoder();
            String encryptedPassword =passwordEncoderDecoder.encrypt(userDto.getPassword());
            userDto.setPassword(encryptedPassword);
            //String decryptedPassword = passwordEncoderDecoder.decrypt(userDto.getPassword());
            //System.out.println("Decrypted Password:- " + decryptedPassword);
        }
        catch (Exception ex)
        {
            System.out.println("Exception: In Password Encoding In User Registration");
        }

        UUID uuid = UUID.randomUUID();
        userDto.setUserId(uuid.toString());
        userDto.setStatus(1);
        userDto.setRoleId("407b779e-dc99-4607-83e9-6f3a1716b3ca");

        userResponse = userRepository.registerUser(userDto);

        return userResponse;
    }
}
