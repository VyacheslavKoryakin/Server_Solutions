package com.examle.demo.workwithdb.Entity;


import jakarta.persistence.*;

import java.math.BigDecimal;



@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "financing", nullable = false)
    private BigDecimal financing = new BigDecimal("0.0");

    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;


    public Departments(BigDecimal financing, String name) {
        this.financing = financing;
        this.name = name;
    }

    public Departments() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getFinancing() {
        return financing;
    }

    public void setFinancing(BigDecimal financing) {
        this.financing = financing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}