package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Service.CarManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/man")
public class CarManufacturerController {
    @Autowired
    CarManufacturerService carManufacturerService;

    @GetMapping("/getById")
    public ResponseEntity<CarManufacturer> findCarById(@RequestParam long id) {
        return carManufacturerService.findCarById(id) ;
    }

    @GetMapping("/get")
    public ResponseEntity <List<CarManufacturer>> findAll() {
        return carManufacturerService.findAll() ;
    }
}
