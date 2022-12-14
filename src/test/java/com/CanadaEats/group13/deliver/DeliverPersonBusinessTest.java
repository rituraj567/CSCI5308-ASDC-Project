package com.CanadaEats.group13.deliver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.CanadaEats.group13.delivery_person.repository.IDeliverRepository;
import com.CanadaEats.group13.order.OrderMock;
import com.CanadaEats.group13.order.dto.OrderDTO;

public class DeliverPersonBusinessTest {
    IDeliverRepository deliveryMock;

    @BeforeEach
    public void setUp() {
        deliveryMock = new DeliverMockDB();

    }

    //
    // ArrayList<OrderDTO> returnArray = new ArrayList<>();
    // returnArray.add(new
    // OrderDTO(1,"ie912","user1","rest88","irc421",31,"Pending",ApplicationConstants.CREDIT_CARD,"2022-12-03"));
    // returnArray.add(new
    // OrderDTO(2,"ie913","user2","rest99","irc421",62,"Pending",ApplicationConstants.DEBIT_CARD,"2022-12-03"));
    @Test
    public void displayOrdersTest() {
        OrderDTO orderDTO = new OrderMock().getOrders().get(0);
        assertEquals(orderDTO.getAmount(), 31);
        assertEquals(orderDTO.getStatus(), "Pending");
    }

    @Test
    public void changeToDeliveredTest() {
        boolean status = deliveryMock.changeToDelivered("ie912");
        assertFalse(status);
    }

    @Test
    public void changedToPickUpTest() {
        boolean status = deliveryMock.changeToPickedUp("ie912");
        assertFalse(status);
    }
}
