package com.vkoryakin.jparepository.Entity;

import jakarta.persistence.*;

@Entity
public class Orders {
    public Orders(String status, String date, String orderNumber) {

        this.status = status;
        this.date = date;
        this.orderNumber = orderNumber;
    }

    public Orders() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String status;

    @Column
    private String date;

    @Column
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
