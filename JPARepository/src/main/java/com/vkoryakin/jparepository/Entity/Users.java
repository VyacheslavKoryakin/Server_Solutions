package com.vkoryakin.jparepository.Entity;

import jakarta.persistence.*;

@Entity
public class Users {


    public Users(String name, String secondName, String email) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public Users() {
    }

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;
    @Column
    String secondName;

    @Column
    String email;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
