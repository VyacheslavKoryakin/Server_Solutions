package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import com.vkoryakin.car_spare_parts.Service.SparePartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/sp")
public class SparePartsController {
@Autowired
SparePartsService sparePartsService;
    @GetMapping("/getById")
    public ResponseEntity<SpareParts> findCarById(@RequestParam long id) {
        return sparePartsService.findCarById(id) ;
    }

    @GetMapping("/get")
    public ResponseEntity <List<SpareParts>> findAll() {
        return sparePartsService.findAll() ;
    }

}
