package com.CanadaEats.group13.deliver;

import java.util.HashMap;
import java.util.List;

import com.CanadaEats.group13.delivery_person.repository.IDeliverRepository;
import com.CanadaEats.group13.order.OrderMock;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.repository.IOderRepository;

public class DeliverMockDB implements IDeliverRepository {
    IOderRepository orderMock = new OrderMock();

    public DeliverMockDB() {

    }

    public HashMap<String, String> fakeOrders() {
        HashMap<String, String> fakeOrder = new HashMap<>();
        fakeOrder.put("orderid1", "Pending");
        fakeOrder.put("orderid2", "Picked Up");
        fakeOrder.put("orderid3", "Pending");

        return fakeOrder;
    }

    public OrderDTO getOrderDTO(String orderId) {
        List<OrderDTO> orders = orderMock.getOrders();
        System.out.println("test" + orders.size());
        OrderDTO order = null;

        for (OrderDTO orderDTO : orders) {
            if (orderDTO.getOrder_id().equals(orderId)) {
                order = orderDTO;
            }

        }
        return order;
    }

    @Override
    public boolean changeToDelivered(String orderId) {
        OrderDTO order = getOrderDTO(orderId);

        if (order.getStatus().equals("Delivered")) {
            return true;
        }

        return false;

    }

    @Override
    public boolean changeToPickedUp(String orderId) {
        OrderDTO order = getOrderDTO(orderId);

        if (order.getStatus().equals("Picked Up")) {
            return true;
        }

        return false;
    }

    @Override
    public String orderTableChange(String changes, String checker) {
        return checker;
    }
}
