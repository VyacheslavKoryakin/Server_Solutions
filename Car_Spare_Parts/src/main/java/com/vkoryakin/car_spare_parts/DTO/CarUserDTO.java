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




    public CarUserDTO(Car car, CarManufacturer carManufacturer, SpareParts spareParts, Storage storage) {
        this.car = car;
        this.carManufacturer = carManufacturer;
        this.spareParts = spareParts;
        this.storage = storage;
    }

    public String getCar() {
        return car.getModel();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getCarManufacturer() {
        return carManufacturer.getName();
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public String getSparePartsName() {
        return spareParts.getName();
    }
    public Integer getSparePartsPrice(){
        return spareParts.getPrice();
    }

    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }

    public Integer getStorageRow() {
        return storage.getRow();
    }
    public Integer getStoragePlace() {
        return storage.getPlace();
    }
    public Integer getStorageAmount() {
        return storage.getAmount();
    }
    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
