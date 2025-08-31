package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "storage")
public class Storage {
    public Storage() {
    }

    public Storage(Integer row, Integer place, Integer amount, SpareParts sparePart) {
        this.row = row;
        this.place = place;
        this.amount = amount;
        this.sparePart = sparePart;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name="row")
    private Integer row;
    @Column(name="place")
    private Integer place;
    @Column(name="amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "spare_part_id")
    private SpareParts sparePart;

    public Long getId() {
        return id;
    }


    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getSparePartId() {
        return sparePart.getId();
    }

    public void setSparePart(SpareParts sparePart) {
        this.sparePart = sparePart;
    }
    @OneToOne
    @JoinColumn(name = "spare_parts_id")
    private SpareParts spareParts;
}