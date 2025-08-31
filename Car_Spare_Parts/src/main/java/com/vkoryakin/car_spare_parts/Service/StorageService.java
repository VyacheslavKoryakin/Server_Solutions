package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.Entity.Storage;
import com.vkoryakin.car_spare_parts.Repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;
    public ResponseEntity<Storage> findCarById(long id){
        Optional<Storage> storages = storageRepository.findById(id);
        return ResponseEntity.ok().body(storages.get());
    }

    public ResponseEntity<List<Storage>> findAll(){
        List<Storage> storages = storageRepository.findAll();
        return ResponseEntity.ok(storages);
    }
}
