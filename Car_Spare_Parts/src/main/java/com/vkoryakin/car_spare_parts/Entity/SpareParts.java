package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spare_parts")
public class SpareParts {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    public SpareParts() {

    }

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

    @OneToMany(mappedBy = "spareParts")
    List< CarsSpareParts> carSpareParts;

    @OneToOne(mappedBy = "spareParts")
    Storage storage;
}