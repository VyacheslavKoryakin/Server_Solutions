package org.example.Patterns.Structured.Composite.Product;

import org.example.Patterns.Structured.Composite.Box.BoxInterface;

public class Phone implements BoxInterface {
    String brand;
    String model;
    int price;

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }

    public Phone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public void getPrice() {

        System.out.println("phone: "+ brand+" "+model+" price: "+price);
    }
}
