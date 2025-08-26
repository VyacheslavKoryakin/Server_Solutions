package com.vkoryakin.hw28_06.OneToOne.Two;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "license_id")
    private License license;
}