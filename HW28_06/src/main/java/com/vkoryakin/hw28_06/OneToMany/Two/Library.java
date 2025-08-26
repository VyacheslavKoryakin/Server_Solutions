package com.vkoryakin.hw28_06.OneToMany.Two;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @ManyToOne
    @JoinColumn(name="bookCopy_id")
    private BookCopy bookCopy;
}