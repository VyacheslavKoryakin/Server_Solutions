package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    public Car() {
    }

    public Car(String model, Integer generation, CarManufacturer manufacturer) {
        this.model = model;
        this.generation = generation;
        this.manufacturer = manufacturer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "generation")
    private Integer generation;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private CarManufacturer manufacturer;


    public Long getId() {
        return id;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public CarManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}