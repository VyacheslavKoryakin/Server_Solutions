package com.vkoryakin.car_spare_parts.Service;

import com.vkoryakin.car_spare_parts.DTO.CarPartDetailsDTO;
import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.CarParts;
import com.vkoryakin.car_spare_parts.Entity.Storage;
import com.vkoryakin.car_spare_parts.Repository.CarPartRepository;
import com.vkoryakin.car_spare_parts.Repository.StorageRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarPartService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    StorageRepository storageRepository;
@Autowired
CarPartRepository carPartRepository;

    public ResponseEntity<Optional<List<?>>> getPartsForCar(Long manufacturerId) {
        String sql = "select concat(cm.name, ' ', c.model) as car, c.model, sp.name, sp.price, s.row, s.place, s.amount " +
                "from car_manufacturer cm " +
                "join car c on cm.id = c.manufacturer_id " +
                "join car_parts cp on c.id = cp.car_id " +
                "join spare_parts sp on cp.spare_part_id = sp.id " +
                "join storage s on sp.id = s.spare_part_id " +
                "where cm.id = :manufacturerId";

        List<?> results = entityManager.createNativeQuery(sql)
                .setParameter("manufacturerId", manufacturerId)
                .getResultList();
        System.out.println(results);

//        List<CarPartDetailsDTO> dtoList = results.stream().map(() -> new CarPartDetailsDTO(
//                (String) results.getFirst(),
//                (String) results.getLast().
//                (String) "record[2]",
//                (Integer) 3,
//                (Integer) 4,
//                (Integer) 4,
//                (Integer) 4
//        )).collect(Collectors.toList());

        return ResponseEntity.ok(Optional.of(results));
    }

    /**
     * Decrease the amount of a spare part in storage by 1.
     */
    @Transactional
    public void decrementStorageAmount(Long storageId) {
        Optional<Storage> storageOpt = storageRepository.findById(storageId);
        if (storageOpt.isPresent()) {
            Storage storage = storageOpt.get();
            storage.setAmount(storage.getAmount() - 1);
            storageRepository.save(storage);
        }
    }

    public ResponseEntity<List<CarParts>> getAllCarParts(){
       return ResponseEntity.ok(carPartRepository.findAll());
    }
}