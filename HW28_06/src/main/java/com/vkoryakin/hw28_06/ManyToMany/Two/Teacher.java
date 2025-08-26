package com.vkoryakin.hw28_06.ManyToMany.Two;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    String name;

    @Column(name = "department")
    String department;

    @OneToMany(mappedBy = "teacher")
    private List<TeacherAssignment> teacherAssignments;

}
