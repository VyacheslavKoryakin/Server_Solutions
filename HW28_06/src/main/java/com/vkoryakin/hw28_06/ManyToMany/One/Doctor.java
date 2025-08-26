package com.vkoryakin.hw28_06.ManyToMany.One;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "doctor_name")
    private String name;

    @Column(name = "specialization")
    private String specialization;

    @ManyToMany(mappedBy = "doctors")
    private List<Hospital> hospitals;
}
