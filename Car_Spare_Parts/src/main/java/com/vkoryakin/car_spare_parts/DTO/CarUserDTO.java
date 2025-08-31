package com.vkoryakin.car_spare_parts.DTO;

import com.vkoryakin.car_spare_parts.Entity.Car;
import com.vkoryakin.car_spare_parts.Entity.CarManufacturer;
import com.vkoryakin.car_spare_parts.Entity.SpareParts;
import com.vkoryakin.car_spare_parts.Entity.Storage;
import org.springframework.stereotype.Component;

@Component
public class CarUserDTO {
    public CarUserDTO() {
    }

    private Car car;
    private CarManufacturer carManufacturer;
    private SpareParts spareParts;
    private Storage storage;

String carModel;
String carGeneration;
String carBrand;

String sparePartsName;
int sparePartPrice;


    public CarUserDTO(Car car, CarManufacturer carManufacturer, SpareParts spareParts, Storage storage) {
        this.car = car;
        this.carManufacturer = carManufacturer;
        this.spareParts = spareParts;
        this.storage = storage;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public SpareParts getSpareParts() {
        return spareParts;
    }

    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
