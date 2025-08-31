package com.vkoryakin.car_spare_parts.DTO;

public class CarPartDetailsDTO {
    private String carName;
    private String model;
    private String partName;
    private Integer price;
    private Integer storageRow;
    private Integer storagePlace;
    private Integer storageAmount;


    public CarPartDetailsDTO(String carName, String model, String partName, Integer price, Integer storageRow, Integer storagePlace, Integer storageAmount) {
        this.carName = carName;
        this.model = model;
        this.partName = partName;
        this.price = price;
        this.storageRow = storageRow;
        this.storagePlace = storagePlace;
        this.storageAmount = storageAmount;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStorageRow() {
        return storageRow;
    }

    public void setStorageRow(Integer storageRow) {
        this.storageRow = storageRow;
    }

    public Integer getStoragePlace() {
        return storagePlace;
    }

    public void setStoragePlace(Integer storagePlace) {
        this.storagePlace = storagePlace;
    }

    public Integer getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(Integer storageAmount) {
        this.storageAmount = storageAmount;
    }
}