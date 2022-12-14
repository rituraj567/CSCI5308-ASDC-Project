package com.CanadaEats.group13.order.controller;

import java.util.*;

import com.CanadaEats.group13.authentication.business.IUserBusiness;
import com.CanadaEats.group13.authentication.business.UserBusiness;
import com.CanadaEats.group13.authentication.dto.UserDetailsDto;
import com.CanadaEats.group13.authentication.repository.UserRepository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.utils.ApplicationConstants;
import com.CanadaEats.group13.utils.CookiesLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrderController {

    IOrderRepository iOrderRepository = new IOrderRepository();
    IUserBusiness userService;

    public OrderController() {
        this.userService = new UserBusiness(new UserRepository(DatabaseConnection.getInstance()));

    }

    @GetMapping("/order")
    public String displayOrders(Model model, HttpServletRequest request)

    {
        ArrayList<OrderDTO> order = iOrderRepository.getOrders();
        ArrayList<OrderDisplayDTO> orderDisplay = iOrderRepository.displayOrder(order);

        String userId = CookiesLogic.extractCookie(request, ApplicationConstants.COOKIE_USERID);
        System.out.println("1"+ userId);
        UserDetailsDto userDetailsDto = userService.getUserDetails(userId);
        model.addAttribute("user", userDetailsDto);

        System.out.println(orderDisplay.size());

        System.out.println(userDetailsDto.getFirstName());

        List<OrderDisplayDTO> orders = new ArrayList<>();
        for(OrderDisplayDTO orderDisplayDTO: orderDisplay){
            System.out.println(orderDisplayDTO.getDeliver_person());
            if(orderDisplayDTO.getDeliver_person().equals(userDetailsDto.getFirstName())){
                orders.add(orderDisplayDTO);
            }
        }


        model.addAttribute("orders", orders);


        return "/order/viewOrder";
    }
}
