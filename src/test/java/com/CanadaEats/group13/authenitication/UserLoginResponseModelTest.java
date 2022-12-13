package com.CanadaEats.group13.authenitication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;

public class UserLoginResponseModelTest {
    UserLoginResponseModel userLoginResponseModel;

    @BeforeEach
    public void testSetup() {
        userLoginResponseModel = new UserLoginResponseModel("arpit1234", "0ab745f3-4d0b-472c-9050-986412813900",
                "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", "d0ac2c3e-4713-4a21-8f65-4aec10cab89d");
    }

    @Test
    public void getUserNameTest() {
        assertEquals("arpit1234", userLoginResponseModel.getUserName());
    }

    @Test
    public void getUserIdTest() {
        assertEquals("9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", userLoginResponseModel.getUserId());
    }

    @Test
    public void getRoleIdTest() {
        assertEquals("0ab745f3-4d0b-472c-9050-986412813900", userLoginResponseModel.getRoleId());

    }

    @Test
    public void getRestaurantIdTest() {
        assertEquals("d0ac2c3e-4713-4a21-8f65-4aec10cab89d", userLoginResponseModel.getRestaurantId());

    }

    @Test
    public void setUserNameTest() {
        String newValue = "arpit1234";
        userLoginResponseModel.setUserName(newValue);
        assertEquals(newValue, userLoginResponseModel.getUserName());
    }

    @Test
    public void setUserIdTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174";
        userLoginResponseModel.setUserId(newValue);
        assertEquals(newValue, userLoginResponseModel.getUserId());
    }

    @Test
    public void setRoleIdTest() {
        String newValue = "0ab745f3-4d0b-472c-9050-986412813900";
        userLoginResponseModel.setRoleId(newValue);
        assertEquals(newValue, userLoginResponseModel.getRoleId());
    }

    @Test
    public void setRestaurantIdTest() {
        String newValue = "d0ac2c3e-4713-4a21-8f65-4aec10cab89d";
        userLoginResponseModel.setRestaurantId(newValue);
        assertEquals(newValue, userLoginResponseModel.getRestaurantId());
    }
}
