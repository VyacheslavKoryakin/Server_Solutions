package com.vkoryakin.hw28_06.ManyToMany.Two;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="room_number")
    String roomNumber;

    @Column(name ="building")
    String building;

    @OneToMany(mappedBy = "classroom")
    private List<TeacherAssignment> teacherAssignments;
}
