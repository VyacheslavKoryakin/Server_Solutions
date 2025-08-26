package com.vkoryakin.hw28_06.ManyToMany.One;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "hospital_name")
    private String name;

    @Column(name = "city")
    private String city;

    @ManyToMany
    @JoinTable(
            name = "hospital_doctor",
            joinColumns = @JoinColumn(name = "hospital_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private List<Doctor> doctors;
}
