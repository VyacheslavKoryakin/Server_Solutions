package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.DTO.CarUserDTO;
import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import com.vkoryakin.car_spare_parts.Entity.Storage;
import com.vkoryakin.car_spare_parts.Repository.CarManufacturerRepository;
import com.vkoryakin.car_spare_parts.Repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarUserService {

    @Autowired
    CarService carService;
    @Autowired
    CarManufacturerService carManufacturerService;
    @Autowired
    StorageService storageService;
    @Autowired
    SparePartsService sparePartsService;

    public ResponseEntity<List<CarUserDTO>> getAll(){
        List<CarUserDTO> carUserDTOs = new ArrayList<>();
        ResponseEntity<List<Car>> cars= carService.findAll();
        ResponseEntity<List<CarManufacturer>> cm = carManufacturerService.findAll();
        ResponseEntity<List<Storage>> storages = storageService.findAll();
        ResponseEntity<List<SpareParts>> spareParts = sparePartsService.findAll();
        for (int i = 0; i < 7; i++) {


           carUserDTOs.add( new CarUserDTO(cars.getBody().get(i), cm.getBody().get(i),spareParts.getBody().get(i),storages.getBody().get(i) ));
        }
        return ResponseEntity.ok(carUserDTOs);
    }
}
