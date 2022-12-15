package com.CanadaEats.group13.order.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.order.dto.OrderDTO;
import com.CanadaEats.group13.order.dto.OrderDisplayDTO;
import com.CanadaEats.group13.utils.ApplicationConstants;

@Repository
public class OrderRepository implements IOderRepository {

    IDatabaseConnection databaseConnection;
    Connection connection;
    ArrayList<OrderDTO> orderDTOArrayList;

    public OrderRepository() {

    }

    @Override
    public ArrayList<OrderDTO> getOrders() {
        orderDTOArrayList = new ArrayList<OrderDTO>();
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String orders = " select * from Orders";
            ResultSet orderResult = statement.executeQuery(orders);
            while (orderResult.next()) {
                int id = orderResult.getInt(ApplicationConstants.ORDER_ID);
                String order_id = orderResult.getString(ApplicationConstants.ORDER_ORDER_ID);
                String user_id = orderResult.getString(ApplicationConstants.ORDER_USER_ID);
                String restarunt = findRestaurant(ApplicationConstants.ORDER_RESTUARANT_ID);
                String delivery_id = orderResult.getString(ApplicationConstants.ORDER_DELIVERY_PERSON_ID);
                int total = orderResult.getInt(ApplicationConstants.ORDER_TOTAL_AMOUNT_ID);
                String status = orderResult.getString(ApplicationConstants.ORDER_STATUS_ID);
                String payment = findPayment(orderResult.getString(ApplicationConstants.ORDER_PAYMENT_OPTION_ID));
                Date date = orderResult.getDate(ApplicationConstants.DATE_OF_ORDER);
                DateFormat date_form = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
                String str_date = date_form.format(date);
                orderDTOArrayList.add(
                        new OrderDTO(id, order_id, user_id, restarunt, delivery_id, total, status, payment, str_date));
            }
            connection.close();
            statement.close();
            orderResult.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return orderDTOArrayList;
    }

    @Override
    public String findRestaurant(String restaurant) {
        String name = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String name2 = "\"" + restaurant + "\"";
            String finder = " select Name from Restaurant where RestaurantId =" + "" + name2;
            ResultSet orderDetailResult = statement.executeQuery(finder);
            while (orderDetailResult.next()) {
                name = orderDetailResult.getString("Name");
            }
            connection.close();
            statement.close();
            orderDetailResult.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    @Override
    public String findPayment(String payment) {
        if (payment.equals(ApplicationConstants.DEBIT_CARD)) {
            return "Debit Card";
        } else if (payment.equals(ApplicationConstants.CREDIT_CARD)) {
            return "Credit Card";
        } else if (payment.equals(ApplicationConstants.CASH)) {
            return "Cash";
        } else {
            return "Payment method invalid.";
        }
    }

    @Override
    public String findCustomer(String customer) {
        String fullname = "";
        String firstName = "";
        String lastName = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String name2 = "\"" + customer + "\"";
            String finder = " select FirstName,LastName from User where UserId =" + "" + name2;
            ResultSet orderDetailResult = statement.executeQuery(finder);
            while (orderDetailResult.next()) {
                firstName = orderDetailResult.getString("FirstName");
                lastName = orderDetailResult.getString("LastName");
            }
            fullname = firstName + lastName;
            connection.close();
            statement.close();
            orderDetailResult.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fullname;
    }

    @Override
    public String findPhone(String phone) {
        String phonenum = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String name2 = "\"" + phone + "\"";
            String finder = " select MobileNumber from User where UserId =" + "" + name2;
            ResultSet orderDetailResult = statement.executeQuery(finder);
            while (orderDetailResult.next()) {
                phonenum = orderDetailResult.getString("MobileNumber");
            }
            connection.close();
            statement.close();
            orderDetailResult.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return phonenum;
    }

    public String findDeliverPerson(String deliver) {
        String deliverPerson = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String name2 = "\"" + deliver + "\"";
            String finder = " select Firstname from User where UserId =" + "" + name2;
            ResultSet orderDetailResult = statement.executeQuery(finder);
            while (orderDetailResult.next()) {
                deliverPerson = orderDetailResult.getString("FirstName");
            }
            connection.close();
            statement.close();
            orderDetailResult.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return deliverPerson;

    }

    @Override
    public String findDeliverAdd(String address) {
        String deliverAdd = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            Statement statement = connection.createStatement();
            String name2 = "\"" + address + "\"";
            String finder = " select Address from User where UserId =" + "" + name2;
            ResultSet orderDetailResult = statement.executeQuery(finder);
            while (orderDetailResult.next()) {
                deliverAdd = orderDetailResult.getString("Address");
            }
            connection.close();
            statement.close();
            orderDetailResult.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return deliverAdd;
    }

    @Override
    public ArrayList<OrderDisplayDTO> displayOrder(ArrayList<OrderDTO> orderDTOArrayList) {
        ArrayList<OrderDisplayDTO> orderDisplayDTOArrayList = new ArrayList<OrderDisplayDTO>();

        for (int i = 0; i < orderDTOArrayList.size(); i++) {
            int id = orderDTOArrayList.get(i).getId();
            int amount = orderDTOArrayList.get(i).getAmount();
            String restaurant = orderDTOArrayList.get(i).getRestaurant_id();
            String payment = orderDTOArrayList.get(i).getPayment_options();
            String customer = findCustomer(orderDTOArrayList.get(i).getUser_id());
            String address = findDeliverAdd(orderDTOArrayList.get(i).getUser_id());
            String phone = findPhone(orderDTOArrayList.get(i).getUser_id());
            String status = orderDTOArrayList.get(i).getStatus();
            String deliverPerson = findDeliverPerson(orderDTOArrayList.get(i).getDelivery_id());

            orderDisplayDTOArrayList.add(new OrderDisplayDTO(id, amount, restaurant, payment, customer, address, phone,
                    status, deliverPerson));
        }
        return orderDisplayDTOArrayList;
    }
}
