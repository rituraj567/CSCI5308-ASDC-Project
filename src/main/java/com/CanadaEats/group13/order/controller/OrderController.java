package com.CanadaEats.group13.order.controller;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class OrderController {

    IOrderRepository iOrderRepository = new IOrderRepository();

    public OrderController()
    {

    }

    @GetMapping("/order")
    public String displayOrders(Model model)

    {
        ArrayList<OrderDTO> orders = iOrderRepository.getOrders();
        System.out.println(orders.size());
        model.addAttribute("orders", orders);
        return "/order/viewOrder";
    }
}
