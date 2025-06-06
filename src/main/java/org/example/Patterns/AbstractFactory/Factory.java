package org.example.Patterns.AbstractFactory;

public class Factory {
    private Phone phone;

    public Factory(PhoneFactory phoneFactory) {
        phone = phoneFactory.createPhone();
    }
    public void makePhone() {
        phone.makePhone();
    }
}
