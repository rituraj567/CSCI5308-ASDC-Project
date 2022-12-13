package com.CanadaEats.group13.delivery_person.dto;

import java.util.ArrayList;

import com.CanadaEats.group13.order.dto.OrderDisplayDTO;

public class DeliveryPersonDTO {
    private String name;
    private ArrayList<OrderDisplayDTO> orderAssigned;

    public DeliveryPersonDTO() {
    }

    public DeliveryPersonDTO(String name, ArrayList<OrderDisplayDTO> orderAssigned) {
        this.name = name;
        this.orderAssigned = orderAssigned;
    }

    public String getName() {
        return name;
    }

    public ArrayList<OrderDisplayDTO> getOrderAssigned() {
        return orderAssigned;
    }

    public void setOrderAssigned(ArrayList<OrderDisplayDTO> orderAssigned) {
        this.orderAssigned = orderAssigned;
    }

    public void setName(String name) {
        this.name = name;
    }
}
