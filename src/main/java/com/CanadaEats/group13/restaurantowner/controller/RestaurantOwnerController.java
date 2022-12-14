package com.CanadaEats.group13.restaurantowner.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuDto;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.dto.RestaurantOwnerDto;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class RestaurantOwnerController {
    IRestaurantOwnerBusiness restaurantOwnerBusiness;

    public RestaurantOwnerController() {
        this.restaurantOwnerBusiness = new RestaurantOwnerBusiness(
                new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/restaurantownerhomepage")
    public String getRestaurantOwnerHomePage(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            Cookie[] cookies = request.getCookies();
            Map<String, Cookie> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
            Cookie loggedInUserRestaurantId = cookieMap.get(ApplicationConstants.COOKIE_RESTAURANTID);
            List<RestaurantOwnerDto> menus = restaurantOwnerBusiness.getAllMenus(loggedInUserRestaurantId.getValue());
            model.addAttribute("menus", menus);
            return ApplicationConstants.URL_RESTAURANTOWNER_RESTAURANTOWNERHOMEPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/restaurantowner/newmenu")
    public String addNewMenuPage(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            MenuDto menuDto = DTOFactory.getInstance().createMenuDto();
            model.addAttribute("menu", menuDto);
            return ApplicationConstants.URL_RESTAURANTOWNER_NEWMENUPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/restaurantowner/addmenu")
    public String addMenu(@ModelAttribute MenuDto menuDto, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            Cookie[] cookies = request.getCookies();
            Map<String, Cookie> cookieMap = new HashMap<>();
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
            Cookie loggedInUserRestaurantId = cookieMap.get(ApplicationConstants.COOKIE_RESTAURANTID);
            boolean result = restaurantOwnerBusiness.addMenu(loggedInUserRestaurantId.getValue(), menuDto);
            if (result) {
                return ApplicationConstants.URL_RESTAURANTOWNER_RESTOWNERHOMEPAGE;
            } else {
                return ApplicationConstants.URL_RESTAURANTOWNER_ADDMENUERROR;
            }
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;

    }

    @GetMapping("/restaurantowner/newmenuitem/{MenuId}")
    public String addNewMenuItemPage(@PathVariable("MenuId") String menuId, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            MenuItemDto menuItems = DTOFactory.getInstance().createMenuItemDto();
            model.addAttribute("menuitem", menuItems);
            model.addAttribute("menuId", menuId);
            return ApplicationConstants.URL_RESTAURANTOWNER_NEWMENUITEMPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/restaurantowner/addmenuitem/{MenuId}")
    public String addMenuItem(@ModelAttribute MenuItemDto menuItemDto, @PathVariable("MenuId") String menuId,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            boolean result = restaurantOwnerBusiness.addMenuItem(menuId, menuItemDto);
            if (result) {
                return ApplicationConstants.URL_RESTAURANTOWNER_RESTOWNERHOMEPAGE;
            } else {
                return ApplicationConstants.URL_RESTAURANTOWNER_ADDMENUERROR;
            }
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/restaurantowner/menuitems/{MenuId}")
    public String getMenuItems(@PathVariable("MenuId") String menuId, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<MenuItemDto> menuItems = restaurantOwnerBusiness.getMenuItems(menuId);
            model.addAttribute("menuItems", menuItems);
            return ApplicationConstants.URL_RESTAURANTOWNER_MENUITEMS;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/restaurantowner/menu/{MenuId}/delete")
    public String deleteMenu(@PathVariable("MenuId") String menuId, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            boolean result = restaurantOwnerBusiness.deleteMenu(menuId);
            if (result) {
                return ApplicationConstants.URL_RESTAURANTOWNER_RESTOWNERHOMEPAGE;
            } else {
                return ApplicationConstants.URL_RESTAURANTOWNER_ADDMENUERROR;
            }
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }
}
