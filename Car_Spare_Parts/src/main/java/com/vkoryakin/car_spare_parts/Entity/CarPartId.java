package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CarPartId implements Serializable {
    @Column(name = "car_id")
    private Long carId;

    @Column(name = "spare_part_id")
    private Long sparePartId;

    // Constructors, equals, hashCode
}