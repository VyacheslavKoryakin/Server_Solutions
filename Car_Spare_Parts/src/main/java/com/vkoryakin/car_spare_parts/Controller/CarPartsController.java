package com.vkoryakin.car_spare_parts.Controller;

import com.vkoryakin.car_spare_parts.Entity.CarParts;
import com.vkoryakin.car_spare_parts.Service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CarPartsController {

    @Autowired
    private CarPartService carPartsService;

    // Получить запчасти по ID производителя
    @GetMapping("/get_parts_for_car")
    public ResponseEntity<Optional<List<?>>> getPartsForCar(@RequestParam Long manufacturerId) {
        return carPartsService.getPartsForCar(manufacturerId);
    }

    // Обновить количество на складе
    @PostMapping("/update_storage")
    public ResponseEntity<String> updateStorage(@RequestParam Long storageId, @RequestParam Integer decrement) {
        try {
            carPartsService.decrementStorageAmount(storageId);
            return ResponseEntity.ok("Количество обновлено");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/getParts")
    public ResponseEntity<List<CarParts>> getCarParts() {
      return  carPartsService.getAllCarParts();
    }
}