package com.CanadaEats.group13.order.dto;

public class OrderDTO {
    private int id;
    private String order_id;
    private String user_id;
    private String restaurant_id;
    private String delivery_id;
    private int amount;
    private String status;
    private String payment_options;
    private String date;

    public OrderDTO() {

    }

    public OrderDTO(int id, String order_id, String user_id, String restaurant_id, String delivery_id, int amount,
            String status, String payment_options, String date) {
        this.id = id;
        this.order_id = order_id;
        this.user_id = user_id;
        this.restaurant_id = restaurant_id;
        this.delivery_id = delivery_id;
        this.amount = amount;
        this.status = status;
        this.payment_options = payment_options;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setRestaurant_id(String restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayment_options(String payment_options) {
        this.payment_options = payment_options;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public String getPayment_options() {
        return payment_options;
    }

    public String getRestaurant_id() {
        return restaurant_id;
    }

    public String getStatus() {
        return status;
    }

    public String getUser_id() {
        return user_id;
    }

}
