package com.examle.demo.workwithdb.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "curators")
public class Curators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(name = "surname", nullable = false, columnDefinition = "nvarchar(max)")
    private String surname;


    public Curators(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Curators() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}