package org.example.Patterns.AbstractFactory;

public class SamsungPhone implements Phone{
    @Override
    public void makePhone() {
        System.out.println("Samsung phone created");
    }
}
