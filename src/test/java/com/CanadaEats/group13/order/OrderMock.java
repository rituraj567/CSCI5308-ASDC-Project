package com.CanadaEats.group13.order;

import java.util.ArrayList;
import java.util.HashMap;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOderRepository;

public class OrderMock implements IOderRepository {

    ArrayList<OrderDTO> orderDTOS = new ArrayList<>();
    OrderMockDBs mockDBs = new OrderMockDBs();

    public ArrayList<OrderDTO> getOrders() {
        orderDTOS = mockDBs.fakeOrder();
        return orderDTOS;
    }

    public void deleteOrder(OrderDTO orderDTO) {
        for (OrderDTO i : orderDTOS) {
            if (i.getId() == orderDTO.getId()) {
                orderDTOS.remove(i);
            }
        }
    }

    public String findRestaurant(String resatarunt) {
        String returnValue = "";
        HashMap<String, String> fakeResrt = mockDBs.fakeRestaurant();
        returnValue = fakeResrt.get(resatarunt);

        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }
        return returnValue;
    }

    public String findPayment(String payment) {
        String returnValue = "";
        HashMap<String, String> fakePay = mockDBs.fakePaymentOption();
        returnValue = fakePay.get(payment);

        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }
        return returnValue;
    }

    public String findCustomer(String customer) {
        String returnValue = "";
        HashMap<String, String> fakeCustomer = mockDBs.fakeCustomer();
        returnValue = fakeCustomer.get(customer);

        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }
        return returnValue;
    }

    public String findPhone(String userId) {
        String returnValue = "";

        HashMap<String, String> fakePhone = mockDBs.fakePhoneNumber();
        returnValue = fakePhone.get(userId);
        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }
        return returnValue;
    }

    public String findDeliverAdd(String userId) {
        String returnValue = "";
        HashMap<String, String> fakeAdd = mockDBs.fakeDeliverAdress();
        returnValue = fakeAdd.get(userId);

        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }

        return returnValue;
    }

    public String findDeliverPerson(String deliver) {
        String returnValue = "";
        HashMap<String, String> fakeDeliverPerson = mockDBs.fakeDeliverPerson();
        returnValue = fakeDeliverPerson.get(deliver);

        if (returnValue != null) {
            return returnValue;
        } else {
            returnValue = "User Id not Valid";
        }

        return returnValue;
    }

    public ArrayList<OrderDisplayDTO> displayOrder(ArrayList<OrderDTO> orderDTOS) {
        ArrayList<OrderDisplayDTO> orderDisplayDTOArrayList = new ArrayList<OrderDisplayDTO>();

        for (int i = 0; i < orderDTOS.size(); i++) {
            int id = orderDTOS.get(i).getId();
            int amount = orderDTOS.get(i).getAmount();
            String restaurant = findRestaurant(orderDTOS.get(i).getRestaurant_id());
            String payment = findPayment(orderDTOS.get(i).getPayment_options());
            String customer = findCustomer(orderDTOS.get(i).getUser_id());
            String address = findDeliverAdd(orderDTOS.get(i).getUser_id());
            String phone = findPhone(orderDTOS.get(i).getUser_id());
            String status = orderDTOS.get(i).getStatus();
            String deliverPerson = findDeliverPerson(orderDTOS.get(i).getDelivery_id());

            orderDisplayDTOArrayList.add(new OrderDisplayDTO(id, amount, restaurant, payment, customer, address, phone,
                    status, deliverPerson));
        }
        return orderDisplayDTOArrayList;
    }
}
