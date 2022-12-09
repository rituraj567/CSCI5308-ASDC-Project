package com.CanadaEats.group13.order.dto;

public class OrderDetialsDTO {
    private int id;
    private String order_detial_id;
    private String order_id;
    private String menu_id;
    private int quantity;
    private int total;

    public OrderDetialsDTO()
    {

    }

    public OrderDetialsDTO(int id, String order_detial_id, String order_id,String menu_id,int quantity,int total)
    {
        this.id=id;
        this.order_detial_id=order_detial_id;
        this.order_id=order_id;
        this.menu_id=menu_id;
        this.quantity=quantity;
        this.total=total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_detial_id(String order_detial_id) {
        this.order_detial_id = order_detial_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public String getOrder_detial_id() {
        return order_detial_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }
}
