package com.vkoryakin.car_spare_parts.Entity;

import jakarta.persistence.*;

@Entity
public class CarsSpareParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private   long id;




    @ManyToOne
    @JoinColumn(name ="car_id")
    Car car;

    @ManyToOne
    @JoinColumn(name ="sparePart_id")
    SpareParts spareParts;

}
