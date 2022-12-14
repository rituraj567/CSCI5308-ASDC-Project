package com.CanadaEats.group13.authentication.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.dto.UserLoginDto;
import com.CanadaEats.group13.authentication.factory.IRole;
import com.CanadaEats.group13.authentication.factory.RoleFactory;
import com.CanadaEats.group13.authentication.model.response.UserDetailsResponseModel;
import com.CanadaEats.group13.authentication.model.response.UserLoginResponseModel;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.CookiesLogic;

@Controller
public class UserController {
    IUserBusiness userService;
    RoleFactory roleFactory;

    public UserController() {
        this.userService = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));
        roleFactory = new RoleFactory();
    }

    @GetMapping("/userregistrationpage")
    public String userRegistrationErrorPage(Model model) {
        UserDetailsDto userDetailsDto = DTOFactory.getInstance().createUserDetailsDto();
        model.addAttribute("userregistration", userDetailsDto);
        return ApplicationConstants.URL_AUTHENTICATION_REGISTERUSER;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDetailsDto userDetailsDto) {
        UserDetailsResponseModel userResponse = userService.registerUser(userDetailsDto);
        if (userResponse.getUserId() == null) {
            return ApplicationConstants.URL_AUTHENTICATION_USERREGISTRATIONERRORPAGE;
        } else {
            return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
        }
    }

    @GetMapping("/userregistrationerrorpage")
    public String userRegistrationForm(Model model) {
        String errorMessage = "Some error occured, Please, try again";
        model.addAttribute("errorMessageRegistration", errorMessage);
        return ApplicationConstants.URL_AUTHENTICATION_REGISTERUSERERROR;
    }

    @GetMapping("/userloginpage")
    public String userLoginForm(Model model) {
        UserLoginDto userLoginDto = DTOFactory.getInstance().createUserLoginDto();
        model.addAttribute("userlogin", userLoginDto);
        return ApplicationConstants.URL_AUTHENTICATION_LOGINUSER;
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserLoginDto userLoginDto, HttpServletResponse response) {
        UserLoginResponseModel userLoginResponseModel = userService.loginUser(userLoginDto);
        if (userLoginResponseModel.getRoleId() != null && userLoginResponseModel.getUserName() != null
                && userLoginResponseModel.getUserId() != null) {
            Cookie cookie1 = new Cookie(ApplicationConstants.COOKIE_USERNAME, userLoginResponseModel.getUserName());
            Cookie cookie2 = new Cookie(ApplicationConstants.COOKIE_ROLEID, userLoginResponseModel.getRoleId());
            Cookie cookie3 = new Cookie(ApplicationConstants.COOKIE_USERID, userLoginResponseModel.getUserId());

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.addCookie(cookie3);

            if (userLoginResponseModel.getRestaurantId() != null) {
                Cookie cookie4 = new Cookie(ApplicationConstants.COOKIE_RESTAURANTID,
                        userLoginResponseModel.getRestaurantId());
                response.addCookie(cookie4);
            }

            if (userLoginResponseModel.getRoleId().equals(ApplicationConstants.ADMIN_ROLEID)) {
                IRole role = roleFactory.createRole(ApplicationConstants.ADMIN_ROLE);
                role.getRoleType(response);
                return ApplicationConstants.URL_AUTHENTICATION_ADMINUSERHOMEPAGE;
            } else if (userLoginResponseModel.getRoleId().equals(ApplicationConstants.RESTAURANT_OWNER_ROLEID)) {
                IRole role = roleFactory.createRole(ApplicationConstants.ADMIN_ROLE);
                role.getRoleType(response);
                return ApplicationConstants.URL_AUTHENTICATION_RESTAURANTOWNERHOMEPAGE;
            } else if (userLoginResponseModel.getRoleId().equals(ApplicationConstants.CUSTOMER_ROLEID)) {
                IRole role = roleFactory.createRole(ApplicationConstants.CUSTOMER_ROLE);
                role.getRoleType(response);
                return ApplicationConstants.URL_AUTHENTICATION_USERHOMEPAGE;
            } else if (userLoginResponseModel.getRoleId().equals(ApplicationConstants.DELIVERY_PERSON_ROLEID)) {
                IRole role = roleFactory.createRole(ApplicationConstants.DELIVERY_PERSON_ROLE);
                role.getRoleType(response);
                return ApplicationConstants.URL_AUTHENTICATION_ORDER;
            }
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINERRORPAGE;
    }

    @GetMapping("/userloginerrorpage")
    public String userLoginErrorPage(Model model) {
        String errorMessage = "Some error occured, Please, try again";
        model.addAttribute("errorMessageLogin", errorMessage);
        return ApplicationConstants.URL_AUTHENTICATION_LOGINUSERERROR;
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setValue(ApplicationConstants.COOKIE_EMPTY_STRING);
                cookie.setMaxAge(ApplicationConstants.COOKIE_MAX_AGE);
                cookie.setPath(ApplicationConstants.COOKIE_ROOT_PATH);
                response.addCookie(cookie);
            }
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/viewProfile")
    public String viewProfile(Model model, HttpServletRequest request) {
        String userId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_USERID);
        UserDetailsDto userDetailsDto = userService.getUserDetails(userId);
        model.addAttribute("user", userDetailsDto);
        return ApplicationConstants.URL_AUTHENTICATION_USERVIEWPROFILE;
    }

    @GetMapping("/userProfile/{userId}/edit")
    public String editProfile(@PathVariable("userId") String userId, Model model) {
        UserDetailsDto userDetailsDto = userService.getUserDetails(userId);
        model.addAttribute("user", userDetailsDto);
        return ApplicationConstants.URL_AUTHENTICATION_EDITPROFILE;
    }

    @PostMapping("/users/{userId}")
    public String updateProfile(@PathVariable("userId") String userId,
            @ModelAttribute("restaurant") UserDetailsDto userDetailsDto, Model model) {
        model.addAttribute("user", userDetailsDto);
        userService.updateUserProfile(userDetailsDto);
        return ApplicationConstants.URL_AUTHENTICATION_VIEWPROFILE;
    }

    @GetMapping("/adminuserhomepage")
    public String adminUserHomePage(HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            return ApplicationConstants.URL_AUTHENTICATION_ADMINHOMEPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINERRORPAGE;
    }
}
