package com.CanadaEats.group13.delivery_person.controller;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.delivery_person.repository.DeliverRepository;
import com.CanadaEats.group13.delivery_person.repository.IDeliverRepository;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.SQLException;
import java.util.List;

@Controller
public class DeliveryPersonController {
    IDeliverRepository deliverRepository;

    public DeliveryPersonController() {
        this.deliverRepository = new DeliverRepository(DatabaseConnection.getInstance());
    }

    @GetMapping("/orders/{orderId}")
    public String userRegistrationForm(Model model, @PathVariable("orderId") int orderId) {

        List<OrderDTO> orders = new IOrderRepository().getOrders();
        OrderDTO orderDisplayDTO = null;


        for (OrderDTO displayDTO : orders) {
            System.out.println("3" + displayDTO.getId());
            if (displayDTO.getId() == orderId) {
                orderDisplayDTO = displayDTO;
            }
        }

        model.addAttribute("order", orderDisplayDTO
        );
        return "order/orderPage";
    }

    @GetMapping("/delivery/{orderId}/{orderStatus}/")
    public String updateOrderStatus(@PathVariable("orderId") String orderId, @PathVariable("orderStatus") int orderStatus) throws SQLException {
        if (orderStatus == 2) {
            System.out.println(orderId);
            deliverRepository.changeToPickedUp(orderId);
            System.out.println("pickedup");
        } else {
            deliverRepository.changeToDelivered(orderId);
            System.out.println("delivered");
        }

        return "order/orderPage";
    }
}
