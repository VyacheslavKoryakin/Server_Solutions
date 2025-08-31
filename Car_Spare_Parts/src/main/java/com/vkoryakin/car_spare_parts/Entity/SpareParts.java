package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spare_parts")
public class SpareParts {
    public SpareParts() {
    }

    public SpareParts(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
@Column(name="price")
    private Integer price;

    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}