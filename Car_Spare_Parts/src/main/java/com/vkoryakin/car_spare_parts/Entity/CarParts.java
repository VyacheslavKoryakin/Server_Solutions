package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_parts")
public class CarParts {
    @EmbeddedId
    private CarPartId id;

    @ManyToOne
    @MapsId("carId")
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @MapsId("sparePartId")
    @JoinColumn(name = "spare_part_id")
    private SpareParts sparePart;

    // Constructors, getters, setters
}
