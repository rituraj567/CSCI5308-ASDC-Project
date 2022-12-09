package com.CanadaEats.group13.order.dto;

public class OrderStatusDTO {
    private int id;
    private int status_id;
    private String status;

    public OrderStatusDTO()
    {

    }

    public OrderStatusDTO(int id, int status_id, String status)
    {
        this.id=id;
        this.status_id=status_id;
        this.status=status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getId() {
        return id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public String getStatus(){
        return status;
    }
}
