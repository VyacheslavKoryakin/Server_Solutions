package org.example.Patterns.FactoryMethod;

public class Ship implements Transport{
    @Override
    public void render() {
        System.out.println("Ship created");
    }

    @Override
    public void delivery() {
        System.out.println("Delivery via sea");
    }
}
