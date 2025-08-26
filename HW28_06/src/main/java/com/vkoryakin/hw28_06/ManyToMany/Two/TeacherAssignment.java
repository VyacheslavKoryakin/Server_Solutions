package com.vkoryakin.hw28_06.ManyToMany.Two;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class TeacherAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "hours_per_week")
    private int hoursPerWeek;


    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoom classroom;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}