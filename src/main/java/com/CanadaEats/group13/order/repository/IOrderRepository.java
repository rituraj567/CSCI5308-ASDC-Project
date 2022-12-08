package com.CanadaEats.group13.order.repository;
import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDetialsDTO;
import com.CanadaEats.group13.utils.PasswordEncoderDecoder;
import org.springframework.stereotype.Repository;
import com.CanadaEats.group13.utils.ApplicationConstants;
import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@Repository
public class IOrderRepository implements IOderRepository{

    IDatabaseConnection databaseConnection ;
    Connection connection;

    ResultSet orderResult;



    public IOrderRepository()
    {

    }

    @Override
    public ArrayList<OrderDTO> getOrders() {
        ArrayList<OrderDTO> orderDTOArrayList = new ArrayList<OrderDTO>();

        try{
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement= connection.createStatement();
            String orders= " select * from Orders";
            ResultSet orderResult = statement.executeQuery(orders);

            PasswordEncoderDecoder decoder = new PasswordEncoderDecoder();

            while(orderResult.next())
            {
                int id = orderResult.getInt("Id");
                String order_id= orderResult.getString("OrderId");
                String user_id= orderResult.getString("UserId");
                String restarunt= orderResult.getString("RestaurantId");
                String delivery_id= orderResult.getString("DeliveryPersonId");
                int total= orderResult.getInt("Total_Amount");
                String status= orderResult.getString("OrderStatusId");

                String payment= orderResult.getString("PaymentOptionId");
                if(payment.equals(ApplicationConstants.CREDIT_CARD))
                {
                    payment = "Credit Card";
                }
                else if (payment.equals(ApplicationConstants.DEBIT_CARD)) {
                    payment = "Debit Card";
                }
                else {
                    payment = "Cash";
                }
                Date date=orderResult.getDate("Date_of_order");
                DateFormat date_form = new SimpleDateFormat("yyyy-mm-dd");
                String str_date= date_form.format(date);
                orderDTOArrayList.add(new OrderDTO(id,order_id,user_id,restarunt,delivery_id,total,status,payment,str_date));
            }
            connection.close();
            statement.close();
            orderResult.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orderDTOArrayList;
    }

//    public static void main(String args[]) throws SQLException
//    {
//
//        IOrderRepository hi = new IOrderRepository();
//
//        ArrayList<OrderDTO> hello = hi.getOrders();
//
//        System.out.println(hello.size());
//
//        System.out.println(hello.get(0).getPayment_options());
//
//
//
//    }

//    @Override
//    public void enumallOrder(ArrayList<OrderDTO> orderArraylist)
//    {
//        for(int i=0; i< orderArraylist.size(); i++)
//        {
//            System.out.println(orderArraylist.get(i).getId());
//            System.out.println(orderArraylist.get(i).getOrder_id());
//            System.out.println(orderArraylist.get(i).getUser_id());
//            System.out.println(orderArraylist.get(i).getRestaurant_id());
//            System.out.println(orderArraylist.get(i).getDelivery_id());
//            System.out.println(orderArraylist.get(i).getAmount());
//            System.out.println(orderArraylist.get(i).getStatus());
//            System.out.println(orderArraylist.get(i).getPayment_options());
//            System.out.println(orderArraylist.get(i).getDate());
//        }
//    }





    @Override
    public ArrayList<OrderDetialsDTO> getOrderDetails() {
        ArrayList<OrderDetialsDTO> orderDetialsDTOS = new ArrayList<OrderDetialsDTO>();
        try{
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement= connection.createStatement();
            String orders= " select * from OrderDetail";
            ResultSet orderDetailResult = statement.executeQuery(orders);

            while(orderDetailResult.next()) {
                int order_id= orderDetailResult.getInt("Id");
                String orderDetailId = orderDetailResult.getString("OrderDetailId");
                String orderId = orderDetailResult.getString("OrderId");
                String MenuItemId = orderDetailResult.getString("MenuItemId");
                int quantity = orderDetailResult.getInt("Quantity");
                int total = orderDetailResult.getInt("Total_Amount");

                orderDetialsDTOS.add(new OrderDetialsDTO(order_id, orderDetailId, orderId,MenuItemId,quantity,total));
            }
            connection.close();
            statement.close();
            orderDetailResult.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orderDetialsDTOS;
    }


    @Override
    public void updateOrder(OrderDTO orderDTO) {

    }

    @Override
    public void updateOrderDetails(OrderDetialsDTO orderDetialsDTO) {

    }

    @Override
    public void deleteOrder(OrderDTO orderDTO)
    {

    }

}
