package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller()
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService ;

    @GetMapping("/getById")
    public ResponseEntity<Car> findCarById(@RequestParam long id) {
        return carService.findCarById(id) ;
    }

    @GetMapping("/get")
    public ResponseEntity <List<Car>> findAll() {
        return carService.findAll() ;
    }
}
