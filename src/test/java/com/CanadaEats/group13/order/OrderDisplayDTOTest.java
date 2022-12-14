package com.CanadaEats.group13.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.order.dto.OrderDisplayDTO;

@DisplayName("OrderDisplayDTO test")
public class OrderDisplayDTOTest {

    OrderDisplayDTO orderDisplayDTO;

    @BeforeEach
    public void generateDTO() {
        orderDisplayDTO = new OrderDisplayDTO(1, 51,
                "Cut Steakhouse", "Credit Card", "姚棣文", "5515 Coco Street",
                "9021231234", "Pending", "Manil");
    }

    @Test
    public void getIdTest() {
        assertEquals(1, orderDisplayDTO.getId());
    }

    @Test
    public void getAmountTest() {
        assertEquals(51, orderDisplayDTO.getAmount());
    }

    @Test
    public void getRestaurantTest() {
        assertEquals("Cut Steakhouse", orderDisplayDTO.getRestaurant());
    }

    @Test
    public void getPaymentOptionTest() {
        assertEquals("Credit Card", orderDisplayDTO.getPaymentOption());
    }

    @Test
    public void getCustomer() {
        assertEquals("姚棣文", orderDisplayDTO.getCustomer());
    }

    @Test
    public void getAddressTest() {
        assertEquals("5515 Coco Street", orderDisplayDTO.getAddress());
    }

    @Test
    public void getPhoneTest() {
        assertEquals("9021231234", orderDisplayDTO.getPhone());
    }

    @Test
    public void getStatusTest() {
        assertEquals("Pending", orderDisplayDTO.getStatus());
    }

    @Test
    public void getDeliverPersonTest() {
        assertEquals("Manil", orderDisplayDTO.getDeliver_person());
    }

}
