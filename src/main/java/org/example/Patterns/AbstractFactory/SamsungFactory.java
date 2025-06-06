package org.example.Patterns.AbstractFactory;

public class SamsungFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        return new SamsungPhone();
    }
}
