package com.CanadaEats.group13.authenitication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.common.DTOFactory;

public class UserBusinessTest {

    @InjectMocks
    UserBusiness userBusiness;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    final void registerUserSuccessTest() {

        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        UserDetailsResponseModel userDetailsResponseModel = prepareRegisterData();
        when(userRepository.registerUser(any())).thenReturn(userDetailsResponseModel);

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);

        assertNotNull(result);
        assertEquals("Arpit", result.getFirstName());
    }

    @Test
    final void registerUserFailureTest() {
        UserDetailsDto userDetailsDto = DTOFactory.getInstance().createUserDetailsDto();
        userDetailsDto.setPassword("arpit1234");
        UserDetailsResponseModel userDetailsResponseModel = prepareRegisterData();
        when(userRepository.registerUser(any())).thenReturn(userDetailsResponseModel);

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);

        assertNotNull(result);
        assertNotEquals("Kirtan", result.getFirstName());
    }

    @Test
    final void loginUserSuccessTest() {
        UserLoginDto userLoginDto = DTOFactory.getInstance().createUserLoginDto();
        userLoginDto.setUserName("arpit1234");
        userLoginDto.setPassword("arpit1234");
        UserLoginResponseModel userLoginResponseModel = prepareLoginData();
        when(userRepository.loginUser(any())).thenReturn(userLoginResponseModel);

        UserLoginResponseModel result = userBusiness.loginUser(userLoginDto);

        assertNotNull(result);
        assertEquals("0ab745f3-4d0b-472c-9050-986412813901", result.getRoleId());
    }

    @Test
    final void loginUserFailureTest() {

        UserLoginDto userLoginDto = DTOFactory.getInstance().createUserLoginDto();
        userLoginDto.setUserName("arpit1234");
        userLoginDto.setPassword("arpit1234");
        UserLoginResponseModel userLoginResponseModel = prepareLoginData();
        when(userRepository.loginUser(any())).thenReturn(userLoginResponseModel);

        UserLoginResponseModel result = userBusiness.loginUser(userLoginDto);

        assertNotNull(result);
        assertNotEquals("arpit", result.getUserName());
    }

    @Test
    final void validateRegisterUserSuccessTest() {
        UserDetailsResponseModel userDetailsResponseModel = new UserDetailsResponseModel();
        userDetailsResponseModel.setFirstName("Arpit");
        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        when(userRepository.registerUser(any())).thenReturn(userDetailsResponseModel);

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);
        assertNotNull(result);
        assertEquals("Arpit", result.getFirstName());
    }

    @Test
    final void validateRegisterUserFirstNameFailureTest() {
        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        userDetailsDto.setFirstName("");

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);
        assertNotNull(result);
        assertEquals(null, result.getFirstName());
    }

    @Test
    final void validateRegisterUserUserNameFailureTest() {
        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        userDetailsDto.setUserName("");

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);
        assertNotNull(result);
        assertEquals(null, result.getUserName());
    }

    @Test
    final void validateRegisterUserCityFailureTest() {
        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        userDetailsDto.setCity("");

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);
        assertNotNull(result);
        assertEquals(null, result.getCity());
    }

    @Test
    final void validateRegisterUserCountryFailureTest() {
        UserDetailsDto userDetailsDto = prepareRegisterValidationData();
        userDetailsDto.setCountry("");

        UserDetailsResponseModel result = userBusiness.registerUser(userDetailsDto);
        assertNotNull(result);
        assertEquals(null, result.getCountry());
    }

    private UserDetailsResponseModel prepareRegisterData() {
        UserDetailsResponseModel userDetailsResponseModel = new UserDetailsResponseModel();
        userDetailsResponseModel.setFirstName("Arpit");
        userDetailsResponseModel.setLastName("Ribadiya");
        userDetailsResponseModel.setEmailId("arpit1234@gmail.com");
        userDetailsResponseModel.setUserName("arpit1234");
        userDetailsResponseModel.setMobileNumber("1234567890");
        userDetailsResponseModel.setGender("male");
        return userDetailsResponseModel;
    }

    private UserLoginResponseModel prepareLoginData() {
        UserLoginResponseModel userLoginResponseModel = new UserLoginResponseModel();
        userLoginResponseModel.setUserId("9c7a3caa-9f3d-4f35-8ecc-7020c0a80177");
        userLoginResponseModel.setUserName("arpit1234");
        userLoginResponseModel.setRoleId("0ab745f3-4d0b-472c-9050-986412813901");
        return userLoginResponseModel;
    }

    private UserDetailsDto prepareRegisterValidationData() {
        UserDetailsDto userDetailsDto = DTOFactory.getInstance().createUserDetailsDto();
        userDetailsDto.setFirstName("Arpit");
        userDetailsDto.setLastName("Ribadiya");
        userDetailsDto.setUserName("arpit1234");
        userDetailsDto.setEmailId("arpit@gmail.com");
        userDetailsDto.setPassword("arpit1234");
        userDetailsDto.setAddress("1333 south park street");
        userDetailsDto.setGender("Male");
        userDetailsDto.setCity("Halifax");
        userDetailsDto.setProvince("NS");
        userDetailsDto.setPostalCode("B3J2K9");
        userDetailsDto.setCountry("Canada");

        return userDetailsDto;
    }
}
