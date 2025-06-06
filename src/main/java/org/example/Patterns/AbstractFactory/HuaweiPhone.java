package org.example.Patterns.AbstractFactory;

public class HuaweiPhone implements Phone {
    @Override
    public void makePhone() {
        System.out.println("Huawei phone created");
    }
}
