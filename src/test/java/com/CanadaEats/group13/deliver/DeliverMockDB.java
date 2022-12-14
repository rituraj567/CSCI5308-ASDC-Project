package com.CanadaEats.group13.deliver;

import java.util.HashMap;

public class DeliverMockDB {

    public DeliverMockDB(){

    }

    public HashMap<String,String> fakeOrders()
    {
        HashMap<String,String> fakeOrder=new HashMap<>();
        fakeOrder.put("orderid1","Pending");
        fakeOrder.put("orderid2","Picked Up");
        fakeOrder.put("orderid3","Pending");

        return fakeOrder;
    }
}
