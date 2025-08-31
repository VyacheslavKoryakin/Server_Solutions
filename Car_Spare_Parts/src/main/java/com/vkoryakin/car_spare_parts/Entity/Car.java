package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    public Car(String model, Integer generation, List<SpareParts> spareParts, CarManufacturer manufacturer) {
        this.model = model;
        this.generation = generation;
        this.carManufacturer = manufacturer;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "generation")
    private Integer generation;

    public Long getCarManufacturerId(){
        return carManufacturer.getId();
    }

    public Car() {

    }



    public String getCarManufacturer() {
        return carManufacturer.getName();
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





    @OneToMany(mappedBy = "car")
    List< CarsSpareParts> carSpareParts;

    @ManyToOne
    @JoinColumn(name ="manufacturer_id")
    CarManufacturer carManufacturer;


}

