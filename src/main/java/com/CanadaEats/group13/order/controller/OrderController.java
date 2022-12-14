package com.CanadaEats.group13.order.controller;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.CookiesLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    IOrderRepository iOrderRepository = new IOrderRepository();
    IUserBusiness userService;

    public OrderController() {
        this.userService = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));

    }

    @GetMapping("/order")
    public String displayOrders(Model model, HttpServletRequest request) {
        ArrayList<OrderDTO> order = iOrderRepository.getOrders();
        ArrayList<OrderDisplayDTO> orderDisplay = iOrderRepository.displayOrder(order);

        String roleId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_ROLEID);
        String userId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_USERID);

        System.out.println("1" + userId);

        UserDetailsDto userDetailsDto = userService.getUserDetails(userId);
        model.addAttribute("user", userDetailsDto);

        List<OrderDisplayDTO> ordersDeliver = new ArrayList<>();
        List<OrderDisplayDTO> orders = new ArrayList<>();

        if (roleId.equals(ApplicationConstants.ADMIN_ROLEID)) {
            model.addAttribute("orders", orderDisplay);
            return "/order/viewOrder";
        } else {

            for (OrderDisplayDTO orderDisplayDTO : orderDisplay) {
                System.out.println("Deliver first name: " + orderDisplayDTO.getDeliver_person());
                System.out.println("userDetailsDto.getFirstName" + userDetailsDto.getFirstName());
                if (orderDisplayDTO.getDeliver_person().equals(userDetailsDto.getFirstName())) {
                    ordersDeliver.add(orderDisplayDTO);
                }

            }
            orders = ordersDeliver;

        }

        model.addAttribute("orders", orders);
        return "/order/viewOrder";
    }


}
