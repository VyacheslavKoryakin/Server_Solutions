package com.vkoryakin.hw28_06.OneToOne.Two;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;

@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "licenseNumber")
    private String licenseNumber;

    @Column(name = "expirationDate")
    private LocalDate expirationDate;

    @OneToOne(mappedBy = "license")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Driver driver;
}