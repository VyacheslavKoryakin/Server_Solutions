package com.vkoryakin.car_spare_parts.Repository;

import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarManufacturerRepository extends JpaRepository<CarManufacturer, Long> {

//@Query(value="SELECT name, id  from CarManufacturer where id = :id",nativeQuery = false)
//    ResponseEntity<List<CarManufacturer>> findByCarId(long id);
}