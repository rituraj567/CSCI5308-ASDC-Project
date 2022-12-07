package com.CanadaEats.group13.filter.controller;

import com.CanadaEats.group13.filter.business.FilterBusiness;
import com.CanadaEats.group13.filter.dto.FilterDto;
import com.CanadaEats.group13.utils.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class FilterController {

    @Autowired
    FilterBusiness filterBusiness;

    @GetMapping("/filters")
    public String getAllFilters(Model model, HttpServletRequest request) {
        List<FilterDto> filters = filterBusiness.getAllFilters();
        model.addAttribute("filters", filters);
        Cookie[] cookies = request.getCookies();
        String output = null;
        if (cookies != null) {
            System.out.println("INSIDE IF OF COOKIE");
            output = Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));

            Map<String, Cookie> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }

            Cookie firstRequiredCookie = cookieMap.get(ApplicationConstants.COOKIE_USERNAME);
            System.out.println("UserName : " + firstRequiredCookie.getValue());
            Cookie nextRequiredCookie = cookieMap.get(ApplicationConstants.COOKIE_ROLEID);
            System.out.println("RoleId : " + nextRequiredCookie.getValue());

        }
        System.out.println("COOKIES : " + output);
        return "/filter/displayFilters";
    }

    @PostMapping("/updatefilters")
    public String updateFilters(@ModelAttribute List<FilterDto> filterDto,Model model){
        System.out.println("Request has reached");
        filterBusiness.updateFilters(filterDto);
        return "redirect:/filters";
    }
}
