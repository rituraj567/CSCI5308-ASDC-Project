package com.CanadaEats.group13.order;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOderRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderMock implements IOderRepository {

    ArrayList<OrderDTO> orderDTOS = new ArrayList<>();
    MockDBs mockDBs = new MockDBs();
    ArrayList<OrderDisplayDTO> orderDisplayDTOS = new ArrayList<>();

    public ArrayList<OrderDTO> getOrders()
    {
        orderDTOS = mockDBs.fakeOrder();
        return orderDTOS;
    }

    public void deleteOrder(OrderDTO orderDTO)
    {
            for(OrderDTO i : orderDTOS)
            {
                if(i.getId()==orderDTO.getId())
                {
                    orderDTOS.remove(i);
                }
            }
    }

    public String findRestaurant(String resatarunt){
        String returnValue="";
        ArrayList<String> fakeRestaurant = mockDBs.fakeRestaurant();

        for(int i=0; i<fakeRestaurant.size();i++)
        {
            if(fakeRestaurant.get(i).equals(resatarunt))
            {
                returnValue=fakeRestaurant.get(i);
            }
            else
            {
                returnValue= "Cannot find restaurant";
            }
        }
        return returnValue;
    }

    public String findPayment(String payment)
    {
        String returnValue="";
        ArrayList<String> fakePayment = mockDBs.fakePaymentOption();
        for(int i=0; i<fakePayment.size();i++)
        {
            if(fakePayment.get(i).equals(payment))
            {
                returnValue=fakePayment.get(i);
            }
            else
            {
                returnValue= "Invalid payment option";
            }
        }
        return returnValue;
    }
    public String findCustomer(String customer){

        String returnValue="";
        ArrayList<String> fakeCustomer = mockDBs.fakeCustomer();

        for(int i=0; i<fakeCustomer.size();i++)
        {
            if(fakeCustomer.get(i).equals(customer))
            {
                returnValue=fakeCustomer.get(i);
            }
            else
            {
                returnValue= "Cannot find customer";
            }
        }
        return returnValue;
    }

    public String findPhone(String userId){
        String returnValue="";

        HashMap<String,String> fakePhone=mockDBs.fakePhoneNumber();
        returnValue=fakePhone.get(userId);
        if(returnValue!=null)
        {
            return returnValue;
        }
        else {
            returnValue = "User Id not Valid";
        }
        return returnValue;
    }

    public String findDeliverAdd(String userId){
        String returnValue="";
        HashMap<String,String> fakeAdd=mockDBs.fakeDeliverAdress();
        returnValue=fakeAdd.get(userId);

        if(returnValue!=null)
        {
            return returnValue;
        }
        else {
            returnValue = "User Id not Valid";
        }

        return returnValue;
    }

    public String findDeliverPerson(String deliver){
        return "ji";
    }

    public ArrayList<OrderDisplayDTO> displayOrder(ArrayList<OrderDTO> orderDTO){
        return null;
    }
}
