package com.CanadaEats.group13.delivery_person.business;

import com.CanadaEats.group13.delivery_person.repository.IDeliverRepository;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.repository.IOrderRepository;

import java.util.List;

public class DeliverPersonBusiness implements IDeliveryPersonBusiness {
    IDeliverRepository deliverRepository;

    public DeliverPersonBusiness(IDeliverRepository deliverRepository) {
        this.deliverRepository = deliverRepository;
    }


    @Override
    public OrderDTO displayOrders(int orderId) {
        List<OrderDTO> orders = new IOrderRepository().getOrders();
        OrderDTO orderDisplayDTO = null;


        for (OrderDTO displayDTO : orders) {
            System.out.println("3" + displayDTO.getId());
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
            System.out.println("pickedup");
        } else {
            deliverRepository.changeToDelivered(orderId);
            System.out.println("delivered");
        }
    }
}
