package org.example.Patterns.AbstractFactory;

public class HuaweiFactory implements PhoneFactory{
    @Override
    public Phone createPhone() {
        return new HuaweiPhone();
    }
}
