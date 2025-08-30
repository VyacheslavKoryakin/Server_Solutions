package com.vkoryakin.jparepository.DTO;



public class OrderDTO {
    public OrderDTO(String status, String date, String orderNumber) {
        this.status = status;
        this.date = date;
        this.orderNumber = orderNumber;
    }

    private String status;


    private String date;


    private String orderNumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
