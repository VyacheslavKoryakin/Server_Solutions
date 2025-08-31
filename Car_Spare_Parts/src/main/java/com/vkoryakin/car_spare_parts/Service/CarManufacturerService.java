package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Repository.CarManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManufacturerService {

    @Autowired
    CarManufacturerRepository carManufacturerRepository;

    public ResponseEntity<CarManufacturer> findCarById(long id){
        Optional<CarManufacturer> manufacturers = carManufacturerRepository.findById(id);
        return ResponseEntity.ok().body(manufacturers.get());
    }

    public ResponseEntity<List<CarManufacturer>> findAll(){
        List<CarManufacturer> manufacturers = carManufacturerRepository.findAll();
        return ResponseEntity.ok(manufacturers);
    }

}
