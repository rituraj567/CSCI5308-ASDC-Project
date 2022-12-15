package com.CanadaEats.group13.delivery_person.business;

import com.CanadaEats.group13.order.dto.OrderDTO;

public interface IDeliveryPersonBusiness {
    OrderDTO displayOrders(int orderId);

    void updateOrderStatus(String orderId, int orderStatus);
}
