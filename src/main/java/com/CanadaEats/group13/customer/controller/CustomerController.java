package com.CanadaEats.group13.customer.controller;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.common.DTOFactory;
import com.CanadaEats.group13.customer.business.CustomerPageHelpers;
import com.CanadaEats.group13.customer.dto.RatingDto;
import com.CanadaEats.group13.customer.repository.CustomerRepository;
import com.CanadaEats.group13.customer.repository.ICustomerRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.restaurant.business.IRestaurantBusiness;
import com.CanadaEats.group13.restaurant.business.RestaurantBusiness;
import com.CanadaEats.group13.restaurant.dto.RestaurantDTO;
import com.CanadaEats.group13.restaurant.repository.RestaurantRepository;
import com.CanadaEats.group13.restaurantowner.business.IRestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.business.RestaurantOwnerBusiness;
import com.CanadaEats.group13.restaurantowner.dto.MenuItemDto;
import com.CanadaEats.group13.restaurantowner.model.request.MenuRequestModel;
import com.CanadaEats.group13.restaurantowner.repository.IRestaurantOwnerRepository;
import com.CanadaEats.group13.restaurantowner.repository.RestaurantOwnerRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.CookiesLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    IUserBusiness userBusiness;
    IRestaurantBusiness restaurantBusiness;
    IRestaurantOwnerBusiness restaurantOwnerBusiness;
    IRestaurantOwnerRepository repository;
    ICustomerRepository customerRepository;

    public CustomerController() {
        this.userBusiness = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));
        this.restaurantBusiness = new RestaurantBusiness(new RestaurantRepository(DatabaseConnection.getInstance()));
        this.restaurantOwnerBusiness = new RestaurantOwnerBusiness(
                new RestaurantOwnerRepository(DatabaseConnection.getInstance()));
        this.repository = new RestaurantOwnerRepository(DatabaseConnection.getInstance());
        this.customerRepository = new CustomerRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/userHomePage")
    public String displayHomePage(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<RestaurantDTO> restaurantDTOList = restaurantBusiness.getAllRestaurants();
            model.addAttribute("restaurants", restaurantDTOList);
            return ApplicationConstants.URL_RESTAURANT_CUSTOMER_HOME_PAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/customer/restaurants/search")
    public String searchRestaurants(@RequestParam("query") String query, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            List<RestaurantDTO> restaurantDTOList = restaurantBusiness.searchRestaurants(query);
            model.addAttribute("restaurants", restaurantDTOList);
            return ApplicationConstants.URL_RESTAURANT_CUSTOMER_HOME_PAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/restaurant/{restaurantId}/display")
    public String showRestaurant(@PathVariable("restaurantId") String restaurantId, Model model,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
            String id = restaurantDTO.getRestaurantId();
            model.addAttribute("restaurant", restaurantDTO);

            List<List<MenuItemDto>> menuItems = CustomerPageHelpers.getMenuItems(id);
            model.addAttribute("menuItems", menuItems);
            return ApplicationConstants.URL_RESTAURANT_RESTAURANT_DISPLAY;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;

    }

    @GetMapping("/customer/menuItems/{restaurantId}/{id}/search")
    public String searchMenuItems(@PathVariable("restaurantId") String restaurantId, @PathVariable("id") int id,
            @RequestParam("query") String query, Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);

            model.addAttribute("restaurant", restaurantDTO);

            List<List<MenuItemDto>> menuItemsResult = CustomerPageHelpers.getMenuItems(restaurantId);
            List<List<MenuItemDto>> menuItems = CustomerPageHelpers.searchMenuItems(menuItemsResult, query);

            model.addAttribute("menuItems", menuItems);

            return ApplicationConstants.URL_RESTAURANT_RESTAURANT_DISPLAY;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/addtocart/{menuId}/{menuItemId}/")
    public String addItemsToCart(@PathVariable("menuId") String menuId, @PathVariable("menuItemId") String menuItemId,
            Model model, HttpServletRequest request) {

        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            MenuItemDto menuItemDto = repository.getMenuItem(menuItemId);
            Map<String, int[]> cartItems = CustomerPageHelpers.addItemsToCart(menuItemDto);

            model.addAttribute("cartItems", cartItems);

            MenuRequestModel menuRequestModel = repository.getMenu(menuId);
            String restaurantId = menuRequestModel.getRestaurantId();

            RestaurantDTO restaurantDTO = restaurantBusiness.getRestaurantById(restaurantId);
            String id = restaurantDTO.getRestaurantId();
            model.addAttribute("restaurant", restaurantDTO);

            List<List<MenuItemDto>> menuItems = CustomerPageHelpers.getMenuItems(id);
            model.addAttribute("menuItems", menuItems);

            return ApplicationConstants.URL_RESTAURANT_RESTAURANT_DISPLAY;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/checkout/")
    public String checkoutCart(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            HashMap<String, int[]> cartItems = CustomerPageHelpers.getCartItems();
            model.addAttribute("cartItems", cartItems);
            List<int[]> cartlist = new ArrayList<int[]>(cartItems.values());
            List<String> keys = new ArrayList<>(cartItems.keySet());
            model.addAttribute("keys", keys);
            model.addAttribute("cartList", cartlist);
            return ApplicationConstants.URL_RESTAURANT_CHECKOUT;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/payment")
    public String makePayment(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            int gradTotal = CustomerPageHelpers.getGrandTotal();
            model.addAttribute("grandTotal", gradTotal);
            return ApplicationConstants.URL_CUSTOMER_PAYMENT_PAYMENT;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/successPayment")
    public String confirmPayment(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            return ApplicationConstants.URL_CUSTOMER_PAYMENT_SUCCESSPAYMENT;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @GetMapping("/createfeedbackpage/{restaurantid}")
    public String createFeedBack(@PathVariable("restaurantid") String restaurantId, Model model,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            RatingDto userDetailsDto = DTOFactory.getInstance().createRatingDto();
            model.addAttribute("userrating", userDetailsDto);
            model.addAttribute("restaurantid", restaurantId);
            return ApplicationConstants.URL_CUSTOMER_USERRATING;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }

    @PostMapping("/addfeedback/{restaurantid}")
    public String addFeedBack(@PathVariable("restaurantid") String restaurantId, @ModelAttribute RatingDto ratingDto,
            HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            String userId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_USERID);
            ratingDto.setRestaurantId(restaurantId);
            ratingDto.setUserId(userId);
            customerRepository.addFeedBack(ratingDto);
            return ApplicationConstants.URL_AUTHENTICATION_USERHOMEPAGE;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINPAGE;
    }
}
