package com.examle.demo.workwithdb.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 10, unique = true)
    private String name;

    @Column(name = "year", nullable = false)
    private Integer year;




    public Groups(String name, Integer year) {
        this.name = name;
        this.year = year;
    }

    public Groups() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year >= 1 && year <= 5) {
            this.year = year;
        } else {
            throw new IllegalArgumentException("Курс должен быть от 1 до 5");
        }
    }
}