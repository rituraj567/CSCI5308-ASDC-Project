package com.CanadaEats.group13.delivery_person.repository;

import com.CanadaEats.group13.database.DatabaseConnection;
import com.CanadaEats.group13.database.IDatabaseConnection;
import com.CanadaEats.group13.order.repository.OrderRepository;
import com.CanadaEats.group13.utils.ApplicationConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeliverRepository implements IDeliverRepository {

    IDatabaseConnection databaseConnection;
    Connection connection;
    Statement statement;
    ResultSet result;
    OrderRepository orderRepository = new OrderRepository();

    public DeliverRepository() {

    }


    public DeliverRepository(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean changeToPickedUp(String orderId) {
        boolean changedPickup;
        String name2 = "\"" + orderId + "\"";
        String feedback;
        String pickup = "Picked Up";
        String pickUp = "\"" + pickup + "\"";
        String changeStatus = "UPDATE Orders SET OrderStatusId =" + pickUp + " WHERE OrderId =" + name2;
        String status_check = " select OrderStatusId from Orders WHERE OrderStatusId =" + name2;
        feedback = orderTableChange(changeStatus, status_check);

        if (feedback.equals("Picked Up")) {
            System.out.println(ApplicationConstants.ORDER_STATE_CHANGE_SUCCESS);
            changedPickup = true;
        } else {
            System.out.println(ApplicationConstants.ORDER_STATE_CHANGE_ERROR);
            changedPickup = false;
        }
        return changedPickup;
    }

    @Override
    public boolean changeToDelivered(String orderId) {
        boolean changedDelivered;
        String name2 = "\"" + orderId + "\"";
        String feedback;
        String deliver = "Delivered";
        String delivered = "\"" + deliver + "\"";
        String changeStatus = "UPDATE Orders SET OrderStatusId =" + delivered + " WHERE OrderId =" + name2;
        String status_check = " select OrderStatusId from Orders WHERE OrderStatusId =" + name2;
        feedback = orderTableChange(changeStatus, status_check);

        if (feedback.equals("Delivered")) {
            System.out.println(ApplicationConstants.ORDER_STATE_CHANGE_SUCCESS);
            changedDelivered = true;
        } else {
            System.out.println(ApplicationConstants.ORDER_STATE_CHANGE_ERROR);
            changedDelivered = false;
        }
        return changedDelivered;
    }

    @Override
    public String orderTableChange(String changes, String checker) {
        String result = "";
        try {
            databaseConnection = DatabaseConnection.getInstance();
            connection = databaseConnection.getDatabaseConnection();
            PreparedStatement preparedStmt = connection.prepareStatement(changes);
            preparedStmt.execute();
            statement = connection.createStatement();
            ResultSet orderResult = statement.executeQuery(checker);

            while (orderResult.next()) {
                result = orderResult.getString("OrderStatusId");
            }
            connection.close();
            statement.close();
            orderResult.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
