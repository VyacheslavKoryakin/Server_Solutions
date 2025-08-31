package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Repository.CarsSparePartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsSparePartsService {
    @Autowired
    CarsSparePartsRepository carsSparePartsRepository;


}
