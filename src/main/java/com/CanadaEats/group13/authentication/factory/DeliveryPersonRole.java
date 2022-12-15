package com.CanadaEats.group13.authentication.factory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.CanadaEats.group13.utils.ApplicationConstants;

public class DeliveryPersonRole implements IRole {
    @Override
    public void getRoleType(HttpServletResponse response) {
        Cookie cookie = new Cookie(ApplicationConstants.COOKIE_ROLENAME, ApplicationConstants.DELIVERY_PERSON_ROLE);
        response.addCookie(cookie);
    }
}