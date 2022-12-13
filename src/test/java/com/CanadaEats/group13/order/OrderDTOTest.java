package com.CanadaEats.group13.order;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.order.dto.OrderDTO;

@DisplayName("OrderDTO test(s)")
public class OrderDTOTest {
    OrderDTO orderDTO;

    @BeforeEach
    public void generateDTO() {
        orderDTO = new OrderDTO(1, "174566d0-767f-11ed-a1eb-0242ac120002",
                "Diwen Yao", "McDonald", "Manil", 16,
                "Pending", "Credit Card", "2022-12-12");
    }

    @Test
    @DisplayName("get ID test")
    public void getIdTest() {
        assertEquals(1, orderDTO.getId());
    }

    @Test
    @DisplayName("get Order ID test")
    public void getOrderIdTest() {
        assertEquals("174566d0-767f-11ed-a1eb-0242ac120002", orderDTO.getOrder_id());
    }

    @Test
    @DisplayName("get user test")
    public void getUserTest() {
        assertEquals("Diwen Yao", orderDTO.getUser_id());
    }

    @Test
    @DisplayName("get Restaurant test")
    public void getRestaurantTest() {
        assertEquals("McDonald", orderDTO.getRestaurant_id());
    }

    @Test
    @DisplayName("get delivery person test")
    public void getDelivery() {
        assertEquals("Manil", orderDTO.getDelivery_id());
    }

    @Test
    @DisplayName("get amount test")
    public void getAmount() {
        assertEquals(16, orderDTO.getAmount());
    }

    @Test
    @DisplayName("get status test")
    public void getStatusTest() {
        assertEquals("Pending", orderDTO.getStatus());
    }

    @Test
    @DisplayName("get payment option test")
    public void getPaymentTest() {
        assertEquals("Credit Card", orderDTO.getPayment_options());
    }

    @Test
    @DisplayName("get date test")
    public void getDateTest() {
        assertEquals("2022-12-12", orderDTO.getDate());
    }

    @Test
    @DisplayName("set ID test")
    public void setIdTest() {
        orderDTO.setId(2);
        assertEquals(2, orderDTO.getId());
    }

    @Test
    @DisplayName("set Order ID test")
    public void setOrderIdTest() {
        orderDTO.setOrder_id("999123-7fyr-als");
        assertEquals("999123-7fyr-als", orderDTO.getOrder_id());
    }

    @Test
    @DisplayName("set user test")
    public void setUserTest() {
        orderDTO.setUser_id("Liu Haolun");
        assertEquals("Liu Haolun", orderDTO.getUser_id());
    }

    @Test
    @DisplayName("set Restaurant test")
    public void setRestaurantTest() {
        orderDTO.setRestaurant_id("Kanpai");
        assertEquals("Kanpai", orderDTO.getRestaurant_id());
    }

    @Test
    @DisplayName("set delivery person test")
    public void setDelivery() {
        orderDTO.setDelivery_id("ABC John");
        assertEquals("ABC John", orderDTO.getDelivery_id());
    }

    @Test
    @DisplayName("set amount test")
    public void setAmount() {
        orderDTO.setAmount(1616);
        assertEquals(1616, orderDTO.getAmount());
    }

    @Test
    @DisplayName("set status test")
    public void setStatusTest() {
        orderDTO.setStatus("已送达");
        assertEquals("已送达", orderDTO.getStatus());
    }

    @Test
    @DisplayName("set payment option test")
    public void setPaymentTest() {
        orderDTO.setPayment_options("Cash");
        assertEquals("Cash", orderDTO.getPayment_options());
    }

    @Test
    @DisplayName("set date test")
    public void setDateTest() {
        orderDTO.setDate("2022-12-10");
        assertEquals("2022-12-10", orderDTO.getDate());
    }

}
