package com.CanadaEats.group13.order.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Controller
public class OrderController {

    IOrderRepository iOrderRepository = new IOrderRepository();

    public OrderController() {

    }

    @GetMapping("/order")
    public String displayOrders(Model model)

    {
        ArrayList<OrderDTO> order = iOrderRepository.getOrders();
        ArrayList<OrderDisplayDTO> orderDisplay = iOrderRepository.displayOrder(order);

        System.out.println(orderDisplay.size());
        model.addAttribute("orders", orderDisplay);
        return ApplicationConstants.URL_ORDERS;
    }
}
