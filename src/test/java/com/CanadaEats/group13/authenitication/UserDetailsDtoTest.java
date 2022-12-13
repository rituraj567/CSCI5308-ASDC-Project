package com.CanadaEats.group13.authenitication;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.authentication.dto.UserDetailsDto;

public class UserDetailsDtoTest {

    UserDetailsDto userDetailsDto;
    java.sql.Date date;

    @BeforeEach
    public void testSetup() {
        long millis = System.currentTimeMillis();
        date = new java.sql.Date(millis);
        userDetailsDto = new UserDetailsDto(1, "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", "Arpit", "Ribadiya",
                "arpit@gmail.com", "arpit1234", "arpit1234", "1231231234", "Male", date, "1333 south park street",
                "Halifax", "NS", "Canada", "B3J2K9", 1, "0ab745f3-4d0b-472c-9050-986412813900");
    }

    @Test
    public void getUserIdTest() {
        assertEquals("9c7a3caa-9f3d-4f35-8ecc-7020c0a80174", userDetailsDto.getUserId());
    }

    @Test
    public void getFirstNameTest() {
        assertEquals("Arpit", userDetailsDto.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        assertEquals("Ribadiya", userDetailsDto.getLastName());
    }

    @Test
    public void getEmailIdTest() {
        assertEquals("arpit@gmail.com", userDetailsDto.getEmailId());
    }

    @Test
    public void getUserNameTest() {
        assertEquals("arpit1234", userDetailsDto.getUserName());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("arpit1234", userDetailsDto.getPassword());
    }

    @Test
    public void getMobileNumberTest() {
        assertEquals("1231231234", userDetailsDto.getMobileNumber());
    }

    @Test
    public void getGenderTest() {
        assertEquals("Male", userDetailsDto.getGender());
    }

    @Test
    public void getBirthDateTest() {
        assertEquals(date, userDetailsDto.getBirthDate());
    }

    @Test
    public void getAddressTest() {
        assertEquals("1333 south park street", userDetailsDto.getAddress());
    }

    @Test
    public void getCityTest() {
        assertEquals("Halifax", userDetailsDto.getCity());
    }

    @Test
    public void getProvinceTest() {
        assertEquals("NS", userDetailsDto.getProvince());
    }

    @Test
    public void getCountryTest() {
        assertEquals("Canada", userDetailsDto.getCountry());
    }

    @Test
    public void getPostalCodeTest() {
        assertEquals("B3J2K9", userDetailsDto.getPostalCode());
    }

    @Test
    public void getStatusTest() {
        assertEquals(1, userDetailsDto.getStatus());
    }

    @Test
    public void getRoleIdTest() {
        assertEquals("0ab745f3-4d0b-472c-9050-986412813900", userDetailsDto.getRoleId());
    }

    @Test
    public void setUserIdTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174";
        userDetailsDto.setUserId(newValue);
        assertEquals(newValue, userDetailsDto.getUserId());
    }

    @Test
    public void setFirstNameTest() {
        String newValue = "Arpit";
        userDetailsDto.setFirstName(newValue);
        assertEquals(newValue, userDetailsDto.getFirstName());
    }

    @Test
    public void setLastNameTest() {
        String newValue = "Arpit";
        userDetailsDto.setLastName(newValue);
        assertEquals(newValue, userDetailsDto.getLastName());
    }

    @Test
    public void setEmailIdTest() {
        String newValue = "arpit1234@gmail.com";
        userDetailsDto.setEmailId(newValue);
        assertEquals(newValue, userDetailsDto.getEmailId());
    }

    @Test
    public void setUserNameTest() {
        String newValue = "arpit1234";
        userDetailsDto.setFirstName(newValue);
        assertEquals(newValue, userDetailsDto.getUserName());
    }

    @Test
    public void setPasswordTest() {
        String newValue = "arpit1234";
        userDetailsDto.setPassword(newValue);
        assertEquals(newValue, userDetailsDto.getPassword());
    }

    @Test
    public void setMobileNumberTest() {
        String newValue = "1231231234";
        userDetailsDto.setMobileNumber(newValue);
        assertEquals(newValue, userDetailsDto.getMobileNumber());
    }

    @Test
    public void setGenderTest() {
        String newValue = "Male";
        userDetailsDto.setGender(newValue);
        assertEquals(newValue, userDetailsDto.getGender());
    }

    @Test
    public void setBirthDateTest() {
        long millis = System.currentTimeMillis();
        Date newValue = new java.sql.Date(millis);
        userDetailsDto.setBirthDate(newValue);
        assertEquals(newValue, userDetailsDto.getBirthDate());
    }

    @Test
    public void setAddressTest() {
        String newValue = "south street";
        userDetailsDto.setAddress(newValue);
        assertEquals(newValue, userDetailsDto.getAddress());
    }

    @Test
    public void setCityTest() {
        String newValue = "Halifax";
        userDetailsDto.setCity(newValue);
        assertEquals(newValue, userDetailsDto.getCity());
    }

    @Test
    public void setProvinceTest() {
        String newValue = "NS";
        userDetailsDto.setProvince(newValue);
        assertEquals(newValue, userDetailsDto.getProvince());
    }

    @Test
    public void setCountryTest() {
        String newValue = "Canada";
        userDetailsDto.setCountry(newValue);
        assertEquals(newValue, userDetailsDto.getCountry());
    }

    @Test
    public void setPostalCodeTest() {
        String newValue = "B3J2K9";
        userDetailsDto.setPostalCode(newValue);
        assertEquals(newValue, userDetailsDto.getPostalCode());
    }

    @Test
    public void setStatusTest() {
        int newValue = 1;
        userDetailsDto.setStatus(newValue);
        assertEquals(newValue, userDetailsDto.getStatus());
    }

    @Test
    public void setRoleIdTest() {
        String newValue = "0ab745f3-4d0b-472c-9050-986412813900";
        userDetailsDto.setRoleId(newValue);
        assertEquals(newValue, userDetailsDto.getRoleId());
    }
}
