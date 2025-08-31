package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    public Car(List<SpareParts> spareParts) {
        this.spareParts = spareParts;
    }

    public Car(String model, Integer generation, List<SpareParts> spareParts, CarManufacturer manufacturer) {
        this.model = model;
        this.generation = generation;
        this.spareParts = spareParts;
        this.carManufacturer = manufacturer;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "generation")
    private Integer generation;

    public Car() {

    }

    public List<SpareParts> getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(List<SpareParts> spareParts) {
        this.spareParts = spareParts;
    }

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }


//    @ManyToOne
//    @JoinColumn(name = "manufacturer_id")
//    private CarManufacturer manufacturer;


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





    @ManyToMany
    @JoinTable(
            name = "cars_spare_parts",
            joinColumns = @JoinColumn(name = "cars_id"),
            inverseJoinColumns = @JoinColumn(name = "spare_parts_id")
    )
     List<SpareParts> spareParts;

    @ManyToOne
    @JoinColumn(name ="manufacturer_id")
    CarManufacturer carManufacturer;
}

