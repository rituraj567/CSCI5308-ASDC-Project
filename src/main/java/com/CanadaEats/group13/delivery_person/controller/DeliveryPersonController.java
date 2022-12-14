package com.CanadaEats.group13.delivery_person.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.delivery_person.business.DeliverPersonBusiness;
import com.CanadaEats.group13.delivery_person.business.IDeliveryPersonBusiness;
import com.CanadaEats.group13.delivery_person.repository.DeliverRepository;
import com.CanadaEats.group13.order.dto.OrderDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;

@Controller
public class DeliveryPersonController {
    IDeliveryPersonBusiness deliveryPersonBusiness;

    public DeliveryPersonController() {
        this.deliveryPersonBusiness = new DeliverPersonBusiness(new DeliverRepository(DatabaseConnection.getInstance()));
    }

    @GetMapping("/orders/{orderId}")
    public String showOrders(Model model, @PathVariable("orderId") int orderId) {
        OrderDTO orderDisplayDTO = deliveryPersonBusiness.displayOrders(orderId);
        model.addAttribute("order", orderDisplayDTO);
        return "order/orderPage";
    }

    @GetMapping("/delivery/{orderId}/{orderStatus}/")
    public String updateOrderStatus(@PathVariable("orderId") String orderId, @PathVariable("orderStatus") int orderStatus) throws SQLException {
        deliveryPersonBusiness.updateOrderStatus(orderId, orderStatus);
        return "redirect:/order";
    }
}
