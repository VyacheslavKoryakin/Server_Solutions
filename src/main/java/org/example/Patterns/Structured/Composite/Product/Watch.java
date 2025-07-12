package org.example.Patterns.Structured.Composite.Product;

import org.example.Patterns.Structured.Composite.Box.BoxInterface;

public class Watch implements BoxInterface {
    private String name;
    private int price;

    public Watch(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void getPrice() {
        System.out.println("watch: "+ name+" price: "+price);
    }

    @Override
    public String toString() {
        return "Watch{" +
                "watch='" + name+ '\'' +
                ", price=" + price +
                '}';
    }
}
