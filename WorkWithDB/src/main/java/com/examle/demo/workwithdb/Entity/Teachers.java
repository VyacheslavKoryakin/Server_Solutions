package com.examle.demo.workwithdb.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, columnDefinition = "nvarchar(max)")
    private String name;

    @Column(name = "surename", nullable = false, columnDefinition = "nvarchar(max)")
    private String surname;

    @Column(name = "salary", nullable = false)
    private Double salary;


    public Teachers(String surname, String name, Double salary) {
        this.surname = surname;
        this.name = name;
        this.salary = salary;
    }

    public Teachers() {

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        if (salary != null && salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }
    }
}