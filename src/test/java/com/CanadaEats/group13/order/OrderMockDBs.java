package com.CanadaEats.group13.order;

import java.util.ArrayList;
import java.util.HashMap;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.utils.ApplicationConstants;

public class OrderMockDBs {

    public OrderMockDBs() {

    }

    public ArrayList<OrderDTO> fakeOrder() {
        ArrayList<OrderDTO> returnArray = new ArrayList<>();
        returnArray.add(new OrderDTO(1, "ie912", "user1", "rest88", "irc421", 31, "Pending",
                ApplicationConstants.CREDIT_CARD, "2022-12-03"));
        returnArray.add(new OrderDTO(2, "ie913", "user2", "rest99", "irc421", 62, "Pending",
                ApplicationConstants.DEBIT_CARD, "2022-12-03"));

        return returnArray;
    }

    public HashMap<String, String> fakeRestaurant() {
        HashMap<String, String> fakeRestaurant = new HashMap<>();
        fakeRestaurant.put("rest88", "McDonald");
        fakeRestaurant.put("rest99", "FIVE GUYS");
        fakeRestaurant.put("rest100", "Steakhouse");

        return fakeRestaurant;
    }

    public HashMap<String, String> fakePaymentOption() {
        HashMap<String, String> fakePayment = new HashMap<>();
        fakePayment.put(ApplicationConstants.CASH, "Cash");
        fakePayment.put(ApplicationConstants.DEBIT_CARD, "Debit Card");
        fakePayment.put(ApplicationConstants.CREDIT_CARD, "Credit Card");

        return fakePayment;
    }

    public HashMap<String, String> fakeCustomer() {
        HashMap<String, String> fakeCustomer = new HashMap<>();
        fakeCustomer.put("user1", "Diwen");
        fakeCustomer.put("user2", "Yzk");
        fakeCustomer.put("user3", "Yzw");

        return fakeCustomer;
    }

    public HashMap<String, String> fakePhoneNumber() {
        HashMap<String, String> fakePhone = new HashMap<>();
        fakePhone.put("user1", "9021231234");
        fakePhone.put("user2", "9023214321");
        fakePhone.put("user3", "9028893322");

        return fakePhone;
    }

    public HashMap<String, String> fakeDeliverAdress() {
        HashMap<String, String> fakeAdd = new HashMap<>();
        fakeAdd.put("user1", "5515 Coco Street");
        fakeAdd.put("user2", "64 Apple Avenue");
        fakeAdd.put("user3", "97 Bayview");

        return fakeAdd;
    }

    public HashMap<String, String> fakeDeliverPerson() {
        HashMap<String, String> fakeDeliver = new HashMap<>();
        fakeDeliver.put("def123", "John");
        fakeDeliver.put("irc421", "Manil");
        fakeDeliver.put("mqo", "Diwen");

        return fakeDeliver;
    }

}
