package com.examle.demo.workwithdb.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "lectures")
public class Lectures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lecture_room", nullable = false, columnDefinition = "nvarchar(max)")
    private String lectureRoom;

    // Конструкторы, геттеры и сеттеры
    public Lectures() {}

    public Lectures(String lectureRoom) {
        this.lectureRoom = lectureRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectureRoom() {
        return lectureRoom;
    }

    public void setLectureRoom(String lectureRoom) {
        this.lectureRoom = lectureRoom;
    }
}