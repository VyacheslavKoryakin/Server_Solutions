package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;
    public ResponseEntity<Car> findCarById(long id){
        Optional<Car> car = carRepository.findById(id);
        return ResponseEntity.ok().body(car.get());
    }

    public ResponseEntity<List<Car>> findAll(){
       List<Car> cars = carRepository.findAll();
        return ResponseEntity.ok(cars);
    }
}
