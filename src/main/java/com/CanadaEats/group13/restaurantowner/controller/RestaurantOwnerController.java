package com.CanadaEats.group13.restaurantowner.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RestaurantOwnerController {
    IRestaurantOwnerBusiness restaurantBusiness;
    public RestaurantOwnerController()
    {
        this.restaurantBusiness = new RestaurantOwnerBusiness(new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/restaurantownerhomepage")
    public String userRegistrationErrorPage(Model model, HttpServletRequest request){
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if(isAPIAccessible)
        {
            Cookie[] cookies = request.getCookies();
            Map<String, Cookie> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
            Cookie loggedInUserRestaurantId = cookieMap.get(ApplicationConstants.COOKIE_RESTAURANTID);
            List<RestaurantOwnerDto> menus = restaurantBusiness.getAllMenus(loggedInUserRestaurantId.getValue());
            model.addAttribute("menus", menus);
            return "restaurantowner/restaurantownerhomepage";
        }
        return "redirect:/userloginpage";
    }
}
