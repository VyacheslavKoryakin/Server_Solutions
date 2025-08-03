package com.examle.demo.homework.Controller;

import com.examle.demo.homework.Entity.Car;
import com.examle.demo.homework.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
//@RequestMapping(value = "/api", method = RequestMethod.PATCH)
//@RequestMapping(value = "/api", method = RequestMethod.PUT)
@RequestMapping("/api")

public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/add")
    public void addCars() {
        List<Car> cars = List.of(
                new Car("Honda", "CRV", "black", 2015),
                new Car("Opel", "Astra", "black", 2016),
                new Car("Volvo", "S90", "green", 2025),
                new Car("Vaz", "Vesta", "blue", 2024));
        carRepository.saveAll(cars);

    }

    @PutMapping("/car{id}")
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car1 = carOptional.get();
            car1.setBrand(car.getBrand());
            car1.setModel(car.getModel());
            car1.setColor(car.getColor());
            car1.setYear(car.getYear());
            carRepository.save(car1);
            return ResponseEntity.ok(car1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/car{id}")
    @ExceptionHandler
    public ResponseEntity<?> updateCar(@PathVariable Long id, @RequestParam String color) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            carOptional.get().setColor(color);
            return ResponseEntity.ok(carRepository.save(carOptional.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/car")
    public ResponseEntity<?> getCar() {
        List<Car> cars = carRepository.findAll();
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/car")
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        carRepository.save(car);
        List<Car> cars = carRepository.findAll();
        return ResponseEntity.ok(cars.get(cars.size() - 1));
    }

    @DeleteMapping("/car{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable Long id) {
        Car car = carRepository.findById(id).get();
        carRepository.delete(car);

        return ResponseEntity.ok(true);
    }

    @GetMapping("/car/filter")
    public ResponseEntity<?> filterCar(@RequestParam String color, @RequestParam String brand) {
        List<Car> cars = carRepository.findAll();
        List<Car> filteredCars = cars.stream()
                .filter(c -> c.getColor()
                        .equals(color)
                        && c.getBrand()
                        .equals(brand))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredCars);

    }
    @GetMapping("/car/sort")
    public ResponseEntity<?> sortCar() {
        List<Car> cars = carRepository.findAll();
        cars.sort(Comparator.comparingInt(Car::getYear).thenComparing(Car::getColor));
        return ResponseEntity.ok(cars);
    }
}
