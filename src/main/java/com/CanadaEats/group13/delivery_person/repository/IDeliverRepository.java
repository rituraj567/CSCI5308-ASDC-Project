package com.CanadaEats.group13.delivery_person.repository;

import com.CanadaEats.group13.order.dto.OrderDisplayDTO;

import java.util.ArrayList;

public interface IDeliverRepository {
    public ArrayList<OrderDisplayDTO> orders_assigned(String deliverId);
    public boolean changeToDelivered(String orderId);
    public boolean changeToPickedUp(String orderId);

    public String orderTableChange(String changes, String checker);
}
