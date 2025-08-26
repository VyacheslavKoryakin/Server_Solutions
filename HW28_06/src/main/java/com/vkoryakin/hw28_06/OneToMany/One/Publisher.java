package com.vkoryakin.hw28_06.OneToMany.One;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "publisher")
    private List<Magazine> magazines;
}
