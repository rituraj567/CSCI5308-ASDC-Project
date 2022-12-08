package com.CanadaEats.group13.order.repository;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDetialsDTO;

import java.util.*;

public interface IOderRepository {
    public ArrayList<OrderDTO> getOrders();
//    public void enumallOrder(ArrayList<OrderDTO> orderArraylist);
    public ArrayList<OrderDetialsDTO> getOrderDetails();
    public void updateOrder(OrderDTO orderDTO);
    public void updateOrderDetails(OrderDetialsDTO orderDetialsDTO);
    public void deleteOrder(OrderDTO orderDTO);

//    public String pay();
//
//    public abstract class Payment{public abstract String paymentOption(String s);}


}
