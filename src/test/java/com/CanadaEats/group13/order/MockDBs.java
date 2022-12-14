package com.CanadaEats.group13.order;

import java.util.ArrayList;
import java.util.HashMap;

public class MockDBs {

    public MockDBs(){

    }

public ArrayList<String> fakeRestaurant()
{
    ArrayList<String> fakeRestaurant = new ArrayList<>();
    fakeRestaurant.add("FIVE GUYS");
    fakeRestaurant.add("McDonald");
    fakeRestaurant.add("Red Cusine");

    return fakeRestaurant;
}

public ArrayList<String> fakePaymentOption()
{
    ArrayList<String> fakePayment = new ArrayList<>();
    fakePayment.add("Credit Card");
    fakePayment.add("Debit Card");
    fakePayment.add("Cash");
    return fakePayment;
}

public ArrayList<String> fakeCustomer()
{
    ArrayList<String> fakeCustomer = new ArrayList<>();
    fakeCustomer.add("ABC");
    fakeCustomer.add("Diwen");
    fakeCustomer.add("Mike");

    return fakeCustomer;
}

public HashMap<String,String> fakePhoneNumber(){
    HashMap<String,String> fakePhone=new HashMap<>();
    fakePhone.put("Diwen","9021231234");
    fakePhone.put("ABC","9023214321");
    fakePhone.put("Mike","9028893322");

    return fakePhone;
}

public HashMap<String,String> fakeDeliverAdress(){
    HashMap<String,String> fakeAdd=new HashMap<>();
    fakeAdd.put("Diwen","5515 Coco Street");
    fakeAdd.put("ABC","64 Apple Avenue");
    fakeAdd.put("Mike","97 Bayview");

    return fakeAdd;
}




}
