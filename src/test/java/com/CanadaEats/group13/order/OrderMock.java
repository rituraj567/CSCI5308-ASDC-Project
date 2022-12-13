package com.CanadaEats.group13.order;

import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.order.repository.IOderRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderMock implements IOderRepository {

    ArrayList<OrderDTO> orderDTOS = new ArrayList<>();

    public ArrayList<OrderDTO> getOrders()
    {
        orderDTOS.add(new OrderDTO(1,"ie912","Diwen","McDonald","Manil",31,"Pending","Debit Card","2022-12-03"));
        orderDTOS.add(new OrderDTO(2,"ie913","ABC","McDonald","Manil",62,"Pending","Credit Card","2022-12-03"));
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
        ArrayList<String> fakeRestaurant = new ArrayList<>();
        fakeRestaurant.add("FIVE GUYS");
        fakeRestaurant.add("McDonald");
        fakeRestaurant.add("Red Cusine");

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
        ArrayList<String> fakePayment = new ArrayList<>();
        fakePayment.add("Credit Card");
        fakePayment.add("Debit Card");
        fakePayment.add("Cash");

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
        ArrayList<String> fakeCustomer = new ArrayList<>();
        fakeCustomer.add("ABC");
        fakeCustomer.add("Diwen");
        fakeCustomer.add("Mike");

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

        HashMap<String,String> fakePhone=new HashMap<>();
        fakePhone.put("Diwen","9021231234");
        fakePhone.put("ABC","9023214321");
        fakePhone.put("Mike","9028893322");
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

        HashMap<String,String> fakeAdd=new HashMap<>();
        fakeAdd.put("Diwen","");
        fakeAdd.put("ABC","9023214321");
        fakeAdd.put("Mike","9028893322");

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

    public String findDeliverPerson(String deliver);

    public ArrayList<OrderDisplayDTO> displayOrder(ArrayList<OrderDTO> orderDTO);
}
