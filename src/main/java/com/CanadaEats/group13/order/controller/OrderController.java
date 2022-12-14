package com.CanadaEats.group13.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.OrderRepository;
import com.CanadaEats.group13.utils.APIAccessAuthorization;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.CookiesLogic;

@Controller
public class OrderController {

    OrderRepository orderRepository = new OrderRepository();
    IUserBusiness userService;

    public OrderController() {
        this.userService = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));

    }

    @GetMapping("/order")
    public String displayOrders(Model model, HttpServletRequest request) {
        boolean isAPIAccessible = APIAccessAuthorization.getInstance().getAPIAccess(request);
        if (isAPIAccessible) {
            ArrayList<OrderDTO> order = orderRepository.getOrders();
            ArrayList<OrderDisplayDTO> orderDisplay = orderRepository.displayOrder(order);

            String roleId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_ROLEID);
            String userId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_USERID);

            UserDetailsDto userDetailsDto = userService.getUserDetails(userId);
            model.addAttribute("user", userDetailsDto);

            List<OrderDisplayDTO> ordersDeliver = new ArrayList<>();
            List<OrderDisplayDTO> orders = new ArrayList<>();

            if (roleId.equals(ApplicationConstants.ADMIN_ROLEID)) {
                model.addAttribute("orders", orderDisplay);
                return ApplicationConstants.URL_ORDER_VIEWORDER;
            } else {

                for (OrderDisplayDTO orderDisplayDTO : orderDisplay) {
                    if (orderDisplayDTO.getDeliver_person().equals(userDetailsDto.getFirstName())) {
                        ordersDeliver.add(orderDisplayDTO);
                    }
                }
                orders = ordersDeliver;
            }

            model.addAttribute("orders", orders);
            return ApplicationConstants.URL_ORDER_VIEWORDER;
        }
        return ApplicationConstants.URL_AUTHENTICATION_USERLOGINERRORPAGE;
    }
}
