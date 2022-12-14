package com.CanadaEats.group13.delivery_person.repository;

public interface IDeliverRepository {
    public boolean changeToDelivered(String orderId);

    public boolean changeToPickedUp(String orderId);

    public String orderTableChange(String changes, String checker);
}
