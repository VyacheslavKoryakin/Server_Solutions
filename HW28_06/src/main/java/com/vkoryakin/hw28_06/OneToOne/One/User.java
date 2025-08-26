package com.vkoryakin.hw28_06.OneToOne.One;

import jakarta.persistence.*;

@Entity
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "userName")
    private String userName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "setting_id")
    private Setting setting;
}
