package com.CanadaEats.group13.authentication.factory;

import com.CanadaEats.group13.utils.ApplicationConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RestaurantOwnerRole implements IRole{
    @Override
    public void getRoleType(HttpServletResponse response) {
        Cookie cookie = new Cookie(ApplicationConstants.COOKIE_ROLENAME, ApplicationConstants.RESTAURANT_OWNER_ROLE);
        response.addCookie(cookie);
    }
}