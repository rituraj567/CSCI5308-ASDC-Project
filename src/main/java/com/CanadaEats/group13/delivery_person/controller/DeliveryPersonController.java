package com.CanadaEats.group13.delivery_person.controller;
import java.util.*;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeliveryPersonController {
    @GetMapping("/orders/{orderId}")
    public String userRegistrationForm(Model model,@PathVariable("orderId") int orderId) {

        List<OrderDTO> orders = new IOrderRepository().getOrders();
        OrderDTO orderDisplayDTO=null;

        for(OrderDTO displayDTO: orders){
            if(displayDTO.getId() == orderId){
                orderDisplayDTO = displayDTO;
            }
        }

        model.addAttribute("order", orderDisplayDTO
                );
        return "order/orderPage";
    }
}
