package com.CanadaEats.group13.order.repository;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDetialsDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.dto.OrderStatusDTO;

import java.util.*;

public interface IOderRepository {
    public ArrayList<OrderDTO> getOrders();
    public ArrayList<OrderDetialsDTO> getOrderDetails();
    public void deleteOrder(OrderDTO orderDTO);

    public String findRestaurant(String resatarunt);
    public String findPayment(String payment);
    public String findCustomer(String customer);
    public String findPhone(String phone);
    public String findDeliverAdd(String address);
    public String findDeliverPerson(String deliver);

    public ArrayList<OrderDisplayDTO> displayOrder (ArrayList<OrderDTO> orderDTO);
//
//    public abstract class Payment{public abstract String paymentOption(String s);}


}
