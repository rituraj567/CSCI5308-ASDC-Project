package com.CanadaEats.group13.service;

import com.CanadaEats.group13.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.repository.UserRepository;
import com.CanadaEats.group13.shared.dto.UserDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetailsResponseModel registerUser(UserDetailsDto userDto) {
        UserDetailsResponseModel userResponse = new UserDetailsResponseModel();

        UUID uuid = UUID.randomUUID();
        userDto.setUserId(uuid.toString());
        userDto.setStatus(1);
        userDto.setRoleId("407b779e-dc99-4607-83e9-6f3a1716b3ca");

        userResponse = userRepository.registerUser(userDto);

        return userResponse;
    }
}
