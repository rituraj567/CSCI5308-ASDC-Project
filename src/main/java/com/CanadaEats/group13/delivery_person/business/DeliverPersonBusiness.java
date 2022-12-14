package com.CanadaEats.group13.delivery_person.business;

import com.CanadaEats.group13.delivery_person.repository.IDeliverRepository;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.repository.OrderRepository;

import java.util.List;

public class DeliverPersonBusiness implements IDeliveryPersonBusiness {
    IDeliverRepository deliverRepository;

    public DeliverPersonBusiness(IDeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }


    @Override
    public OrderDTO displayOrders(int orderId) {
        List<OrderDTO> orders = new OrderRepository().getOrders();
        OrderDTO orderDisplayDTO = null;


        for (OrderDTO displayDTO : orders) {
            if (displayDTO.getId() == orderId) {
                orderDisplayDTO = displayDTO;
            }
        }
        return orderDisplayDTO;
    }

    @Override
    public void updateOrderStatus(String orderId, int orderStatus) {
        if (orderStatus == 2) {
            System.out.println(orderId);
            deliverRepository.changeToPickedUp(orderId);
        } else {
            deliverRepository.changeToDelivered(orderId);
        }
    }
}
