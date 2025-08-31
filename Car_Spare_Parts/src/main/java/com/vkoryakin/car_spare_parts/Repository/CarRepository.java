package com.vkoryakin.car_spare_parts.Repository;

import com.vkoryakin.car_spare_parts.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface CarRepository extends JpaRepository<Car, Long> {


}
