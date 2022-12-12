package com.CanadaEats.group13.delivery_person.repository;

public interface IDeliverRepository {
    public String getFirst_name();
    public String getLast_name();
    public void orders_assigned();
    public void changestatus();
}
