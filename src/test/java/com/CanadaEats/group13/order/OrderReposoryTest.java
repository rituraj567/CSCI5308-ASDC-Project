package com.CanadaEats.group13.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;

@DisplayName("OrderReposory Test")
public class OrderReposoryTest {

    OrderMock orderMock = new OrderMock();
    ArrayList<OrderDTO> orderDTOS = orderMock.getOrders();

    @Test
    public void getOrderTest() {
        assertEquals(2, orderDTOS.size());
    }

    @Test
    public void findRestaurantTest() {
        assertEquals("FIVE GUYS", orderMock.findRestaurant(orderDTOS.get(1).getRestaurant_id()));
    }

    @Test
    public void findPaymentTest() {
        assertEquals("Credit Card", orderMock.findPayment(orderDTOS.get(0).getPayment_options()));
        assertEquals("Debit Card", orderMock.findPayment(orderDTOS.get(1).getPayment_options()));
    }

    @Test
    public void findCustomerTest() {
        assertEquals("Diwen", orderMock.findCustomer(orderDTOS.get(0).getUser_id()));
        assertEquals("Yzk", orderMock.findCustomer(orderDTOS.get(1).getUser_id()));
    }

    @Test
    public void findPhoneTest() {
        assertEquals("9021231234", orderMock.findPhone(orderDTOS.get(0).getUser_id()));
        assertEquals("9023214321", orderMock.findPhone(orderDTOS.get(1).getUser_id()));
    }

    @Test
    public void findDeliverAddressTest() {
        assertEquals("5515 Coco Street", orderMock.findDeliverAdd(orderDTOS.get(0).getUser_id()));
        assertEquals("64 Apple Avenue", orderMock.findDeliverAdd(orderDTOS.get(1).getUser_id()));
    }

    @Test
    public void findDeliverPersonTest() {
        assertEquals("Manil", orderMock.findDeliverPerson(orderDTOS.get(0).getDelivery_id()));
        assertEquals("Manil", orderMock.findDeliverPerson(orderDTOS.get(1).getDelivery_id()));
    }

    @Test
    public void getDisplayTest() {
        ArrayList<OrderDisplayDTO> displayDTOS = new ArrayList<>();
        ArrayList<OrderDisplayDTO> result = orderMock.displayOrder(orderDTOS);
        displayDTOS.add(new OrderDisplayDTO(1, 31, "McDonald", "Credit Card", "Diwen", "5515 Coco Street",
                "9021231234", "Pending", "Manil"));

        assertEquals(1, result.get(0).getId());
        assertEquals(31, result.get(0).getAmount());
        assertEquals("McDonald", result.get(0).getRestaurant());
        assertEquals("Credit Card", result.get(0).getPaymentOption());
        assertEquals("Diwen", result.get(0).getCustomer());
        assertEquals("5515 Coco Street", result.get(0).getAddress());
        assertEquals("9021231234", result.get(0).getPhone());
        assertEquals("Pending", result.get(0).getStatus());
        assertEquals("Manil", result.get(0).getDeliver_person());
    }

}
