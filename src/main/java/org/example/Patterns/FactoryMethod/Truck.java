package org.example.Patterns.FactoryMethod;

public class Truck implements Transport{
    @Override
    public void render() {
        System.out.println("Truck created");
    }

    @Override
    public void delivery() {
        System.out.println("Delivery via road");
    }
}
