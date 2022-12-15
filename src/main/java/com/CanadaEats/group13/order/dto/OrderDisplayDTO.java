package com.CanadaEats.group13.order.dto;

public class OrderDisplayDTO {
    private int id;
    private int amount;
    private String restaurant;
    private String paymentOption;
    private String customer;
    private String address;
    private String phone;
    private String status;
    private String deliver_person;

    public OrderDisplayDTO() {

    }

    public OrderDisplayDTO(int id, int amount, String restaurant, String paymentOption, String customer, String address,
            String phone, String status, String deliver_person) {
        this.id = id;
        this.amount = amount;
        this.restaurant = restaurant;
        this.paymentOption = paymentOption;
        this.customer = customer;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.deliver_person = deliver_person;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }

    public String getCustomer() {
        return customer;
    }

    public String getDeliver_person() {
        return deliver_person;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public String getPhone() {
        return phone;
    }

    public String getRestaurant() {
        return restaurant;
    }
}
