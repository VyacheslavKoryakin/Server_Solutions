package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.DTO.CarUserDTO;
import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import com.vkoryakin.car_spare_parts.Entity.Storage;
import com.vkoryakin.car_spare_parts.Repository.CarManufacturerRepository;
import com.vkoryakin.car_spare_parts.Repository.CarRepository;
import com.vkoryakin.car_spare_parts.Repository.CarsSparePartsRepository;
import com.vkoryakin.car_spare_parts.Repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private CarManufacturerRepository carManufacturerRepository;
    @Autowired
    CarsSparePartsService carsSparePartsService;

    public ResponseEntity<List<CarUserDTO>> getAll() {
        List<CarUserDTO> carUserDTOs = new ArrayList<>();
        List<Car> cars = carService.findAll().getBody();


        List<CarManufacturer> cm = carManufacturerService.findAll().getBody();
//        List<Long> csp = carsSparePartsService.findAll().getBody();
        List<Storage> storages = storageService.findAll().getBody();
        List<SpareParts> spareParts = sparePartsService.findAll().getBody();
        for (int i = 0; i < cars.size(); i++) {
            final int k = i;


            List<CarManufacturer> cm2 = cm.stream().filter(m -> m.getId().equals(cars.get(k).getCarManufacturerId())).toList();
            List<SpareParts> spareParts2 = spareParts.stream().filter(sp -> sp.getId().equals(storages.get(k).getSparePartId())).toList();


            carUserDTOs.add(new CarUserDTO(cars.get(k), cm2.get(0), spareParts2.get(0), storages.get(k)));
        }
        return ResponseEntity.ok(carUserDTOs);
    }
}
