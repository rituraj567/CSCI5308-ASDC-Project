package com.CanadaEats.group13.authenitication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.authentication.dto.UserLoginDto;

public class UserLoginDtoTest {
    UserLoginDto userLoginDto;

    @BeforeEach
    public void testSetup() {
        userLoginDto = new UserLoginDto("arpit1234", "arpit1234");
    }

    @Test
    public void getUserNameTest() {
        assertEquals("arpit1234", userLoginDto.getUserName());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("arpit1234", userLoginDto.getPassword());
    }

    @Test
    public void setUserNameTest() {
        String newValue = "arpit1234";
        userLoginDto.setUserName(newValue);
        assertEquals(newValue, userLoginDto.getUserName());
    }

    @Test
    public void setPasswordTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174";
        userLoginDto.setPassword(newValue);
        assertEquals(newValue, userLoginDto.getPassword());
    }

}
