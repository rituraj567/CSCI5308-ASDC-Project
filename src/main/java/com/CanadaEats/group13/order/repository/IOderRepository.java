package com.CanadaEats.group13.order.repository;

import java.util.ArrayList;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;

public interface IOderRepository {
    public ArrayList<OrderDTO> getOrders();

    public String findRestaurant(String resatarunt);

    public String findPayment(String payment);

    public String findCustomer(String customer);

    public String findPhone(String phone);

    public String findDeliverAdd(String address);

    public String findDeliverPerson(String deliver);

    public ArrayList<OrderDisplayDTO> displayOrder(ArrayList<OrderDTO> orderDTO);

}
