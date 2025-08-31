package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_manufacturer")
public class CarManufacturer {
    public CarManufacturer(String name) {
        this.name = name;
    }

    public CarManufacturer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
