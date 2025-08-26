package com.vkoryakin.hw28_06.OneToOne.One;

import jakarta.persistence.*;

@Entity
@Table(name="settings")
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "mode")
    private boolean darkMode;

    @Column(name = "language")
    private String language;

    @OneToOne(mappedBy = "setting")
    private User user;
}
