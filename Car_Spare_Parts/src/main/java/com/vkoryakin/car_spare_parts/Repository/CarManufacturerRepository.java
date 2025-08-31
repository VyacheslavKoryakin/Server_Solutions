package com.vkoryakin.car_spare_parts.Repository;

import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarManufacturerRepository extends JpaRepository<CarManufacturer, Long> {}