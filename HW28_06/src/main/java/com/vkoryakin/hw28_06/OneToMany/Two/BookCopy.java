package com.vkoryakin.hw28_06.OneToMany.Two;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "condition")
    private String condition;

    @OneToMany(mappedBy = "bookCopy")
    private List<Library> libraries;
}