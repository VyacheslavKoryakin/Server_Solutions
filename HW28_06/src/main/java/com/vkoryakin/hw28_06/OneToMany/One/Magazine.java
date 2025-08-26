package com.vkoryakin.hw28_06.OneToMany.One;

import jakarta.persistence.*;

@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "issue_number")
    private int issueNumber;

    @ManyToOne
    @JoinColumn(name ="publisher_id")
    Publisher publisher;
}
