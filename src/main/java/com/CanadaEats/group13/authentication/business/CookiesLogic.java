package com.CanadaEats.group13.authentication.business;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookiesLogic {
    public static String extractCookie(HttpServletRequest req, String name) {
        for (Cookie c : req.getCookies()) {
            if (c.getName().equals(name))
                return c.getValue();
        }
        return null;
    }

}
