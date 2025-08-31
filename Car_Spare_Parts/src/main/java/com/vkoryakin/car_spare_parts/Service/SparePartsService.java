package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import com.vkoryakin.car_spare_parts.Repository.CarRepository;
import com.vkoryakin.car_spare_parts.Repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartsService {

    @Autowired
    SparePartRepository sparePartRepository;
    public ResponseEntity<SpareParts> findCarById(long id){
        Optional<SpareParts>spareParts = sparePartRepository.findById(id);
        return ResponseEntity.ok().body(spareParts.get());
    }

    public ResponseEntity<List<SpareParts>> findAll(){
        List<SpareParts> spareParts = sparePartRepository.findAll();
        return ResponseEntity.ok(spareParts);
    }
}
