package com.vkoryakin.jparepository.DTO;



public class ProductDTO {
    public double getPrice() {
        return price;
    }

    public ProductDTO( String name,double price) {
        this.price = price;
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;

private double price;

    public ProductDTO(String name, double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
