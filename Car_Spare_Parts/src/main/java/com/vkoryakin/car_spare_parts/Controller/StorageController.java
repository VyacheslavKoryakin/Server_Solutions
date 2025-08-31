package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.Storage;
import com.vkoryakin.car_spare_parts.Service.CarService;
import com.vkoryakin.car_spare_parts.Service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/st")
public class StorageController {
    @Autowired
   StorageService storageService;

    @GetMapping("/getById")
    public ResponseEntity<Storage> findCarById(@RequestParam long id) {
        return storageService.findCarById(id) ;
    }

    @GetMapping("/get")
    public ResponseEntity <List<Storage>> findAll() {
        return storageService.findAll() ;
    }
}
