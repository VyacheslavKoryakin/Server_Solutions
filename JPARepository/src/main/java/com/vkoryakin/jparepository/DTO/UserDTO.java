package com.vkoryakin.jparepository.DTO;

import jakarta.persistence.Column;

public class UserDTO {
    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserDTO(String name, String secondName, String email) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    String name;
    String secondName;
    String email;

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
