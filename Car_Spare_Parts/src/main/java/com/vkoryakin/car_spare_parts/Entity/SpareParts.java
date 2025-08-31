package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "spare_parts")
public class SpareParts {
    public SpareParts(List<Car> cars) {
        this.cars = cars;
    }

    public SpareParts(String name, Integer price, List<Car> cars) {
        this.name = name;
        this.price = price;
        this.cars = cars;
    }

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

    @ManyToMany(mappedBy = "spareParts")
     List<Car> cars;

    @OneToOne(mappedBy = "spareParts")
    Storage storage;
}