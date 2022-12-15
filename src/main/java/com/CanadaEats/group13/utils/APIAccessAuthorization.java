package com.CanadaEats.group13.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class APIAccessAuthorization {

    private static APIAccessAuthorization apiAccessAuthorization;

    private APIAccessAuthorization() {
    }

    public static APIAccessAuthorization getInstance() {
        if (apiAccessAuthorization == null) {
            apiAccessAuthorization = new APIAccessAuthorization();
        }
        return apiAccessAuthorization;
    }

    public boolean getAPIAccess(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return false;
        }
        return true;
    }
}
