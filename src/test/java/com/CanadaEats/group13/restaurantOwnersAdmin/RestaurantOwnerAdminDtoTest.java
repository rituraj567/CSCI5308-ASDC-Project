package com.CanadaEats.group13.restaurantOwnersAdmin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.restaurantOwnersAdmin.dto.RestaurantOwnerAdminDto;
import com.CanadaEats.group13.utils.ApplicationConstants;

@DisplayName("Restaurant_Owner_Admin DTO class tests")
public class RestaurantOwnerAdminDtoTest {
    public RestaurantOwnerAdminDto restaurantOwnerAdminDto = null;
    public Date date;

    @BeforeEach
    public void testSetup() {
        restaurantOwnerAdminDto = new RestaurantOwnerAdminDto(100, "234", "manil", "patel",
                "manil@dal.ca", "manil123", "manil123", "1234567891", "male",
                date, "1333 south park street", "halifax", "ns",
                "canada", "B3j2K9", 1, ApplicationConstants.RESTAURANT_OWNER_ROLEID);
    }

    @Test
    @DisplayName("getIdTest() test")
    public void getIdTest() {
        assertEquals(100, restaurantOwnerAdminDto.getId());
    }

    @Test
    @DisplayName("getUserIdTest() test")
    public void getUserIdTest() {
        assertEquals("234", restaurantOwnerAdminDto.getUserId());
    }

    @Test
    @DisplayName("getFirstNameTest() test")
    public void getFirstNameTest() {
        assertEquals("manil", restaurantOwnerAdminDto.getFirstName());
    }

    @Test
    @DisplayName("getLastNameTest() test")
    public void getLastNameTest() {
        assertEquals("patel", restaurantOwnerAdminDto.getLastName());
    }

    @Test
    @DisplayName("getLastNameTest() test")
    public void getEmailIdTest() {
        assertEquals("manil@dal.ca", restaurantOwnerAdminDto.getEmailId());
    }

    @Test
    @DisplayName("getUserNameTest() test")
    public void getUserNameTest() {
        assertEquals("manil123", restaurantOwnerAdminDto.getUserName());
    }

    @Test
    @DisplayName("getPasswordTest() test")
    public void getPasswordTest() {
        assertEquals("manil123", restaurantOwnerAdminDto.getPassword());
    }

    @Test
    @DisplayName("getMobileNumberTest() test")
    public void getMobileNumberTest() {
        assertEquals("1234567891", restaurantOwnerAdminDto.getMobileNumber());
    }

    @Test
    @DisplayName("getGenderTest() test")
    public void getGenderTest() {
        assertEquals("male", restaurantOwnerAdminDto.getGender());
    }

    @Test
    @DisplayName("getBirthDateTest() test")
    public void getBirthDateTest() {
        assertEquals(date, restaurantOwnerAdminDto.getBirthDate());
    }

    @Test
    @DisplayName("getAddressTest() test")
    public void getAddressTest() {
        assertEquals("1333 south park street", restaurantOwnerAdminDto.getAddress());
    }

    @Test
    @DisplayName("getCityTest() test")
    public void getCityTest() {
        assertEquals("halifax", restaurantOwnerAdminDto.getCity());
    }

    @Test
    @DisplayName("getProvinceTest() test")
    public void getProvinceTest() {
        assertEquals("ns", restaurantOwnerAdminDto.getProvince());
    }

    @Test
    @DisplayName("getCountryTest() test")
    public void getCountryTest() {
        assertEquals("canada", restaurantOwnerAdminDto.getCountry());
    }

    @Test
    @DisplayName("getPostCodeTest() test")
    public void getPostCodeTest() {
        assertEquals("B3j2K9", restaurantOwnerAdminDto.getPostalCode());
    }

    @Test
    @DisplayName("getStatusTest() test")
    public void getStatusTest() {
        assertEquals(1, restaurantOwnerAdminDto.getStatus());
    }

    @Test
    @DisplayName("getRoleIdTest() test")
    public void getRoleIdTest() {
        assertEquals(ApplicationConstants.RESTAURANT_OWNER_ROLEID, restaurantOwnerAdminDto.getRoleId());
    }

    @Test
    @DisplayName("setUserIdTest() test")
    public void setUserIdTest() {
        String newValue = "9c7a3caa-9f3d-4f35-8ecc-7020c0a80174";
        restaurantOwnerAdminDto.setUserId(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getUserId());
    }

    @Test
    @DisplayName("setFirstNameTest() test")
    public void setFirstName() {
        String newValue = "hello";
        restaurantOwnerAdminDto.setFirstName(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getFirstName());
    }

    @Test
    @DisplayName("setLastNameTest() test")
    public void setLastNameTest() {
        String newValue = "world";
        restaurantOwnerAdminDto.setLastName(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getLastName());
    }

    @Test
    @DisplayName("setEmailIdTest() test")
    public void setEmailIdTest() {
        String newValue = "hello@dal.ca";
        restaurantOwnerAdminDto.setEmailId(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getEmailId());
    }

    @Test
    @DisplayName("setUserNameTest() test")
    public void setUserNameTest() {
        String newValue = "hello123";
        restaurantOwnerAdminDto.setUserName(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getUserName());
    }

    @Test
    @DisplayName("setPasswordTest() test")
    public void setPasswordTest() {
        String newValue = "hello123";
        restaurantOwnerAdminDto.setPassword(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getPassword());
    }

    @Test
    @DisplayName("setMobileNumber() test")
    public void setMobileNumber() {
        String newValue = "7897897897";
        restaurantOwnerAdminDto.setMobileNumber(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getMobileNumber());
    }

    @Test
    @DisplayName("setGenderTest() test")
    public void setGenderTest() {
        String newValue = "female";
        restaurantOwnerAdminDto.setGender(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getGender());
    }

    @Test
    @DisplayName("setBirthDateTest() test")
    public void setBirthDateTest() {
        date = new Date(2000, 01, 05);
        restaurantOwnerAdminDto.setBirthDate(date);
        assertEquals(date, restaurantOwnerAdminDto.getBirthDate());
    }

    @Test
    @DisplayName("setAddressTest() test")
    public void setAddressTest() {
        String newValue = "1991 brunswick street";
        restaurantOwnerAdminDto.setAddress(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getAddress());
    }

    @Test
    @DisplayName("setCityTest() test")
    public void setCityTest() {
        String newValue = "Toronto";
        restaurantOwnerAdminDto.setCity(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getCity());
    }

    @Test
    @DisplayName("setProvinceTest() test")
    public void setProvinceTest() {
        String newValue = "NB";
        restaurantOwnerAdminDto.setProvince(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getProvince());
    }

    @Test
    @DisplayName("setCountryTest() test")
    public void setCountryTest() {
        String newValue = "India";
        restaurantOwnerAdminDto.setCountry(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getCountry());
    }

    @Test
    @DisplayName("setPostalCodeTest() test")
    public void setPostalCodeTest() {
        String newValue = "B3J2G9";
        restaurantOwnerAdminDto.setPostalCode(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getPostalCode());
    }

    @Test
    @DisplayName("setStatusTest() test")
    public void setStatusTest() {
        int status = 0;
        restaurantOwnerAdminDto.setStatus(status);
        assertEquals(status, restaurantOwnerAdminDto.getStatus());
    }

    @Test
    @DisplayName("setRoleIdTest() test")
    public void setRoleIdTest() {
        String newValue = ApplicationConstants.ADMIN_ROLEID;
        restaurantOwnerAdminDto.setRoleId(newValue);
        assertEquals(newValue, restaurantOwnerAdminDto.getRoleId());
    }

}
