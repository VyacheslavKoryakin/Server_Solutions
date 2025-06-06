package org.example.Patterns.FactoryMethod;

public class TruckDialog extends Dialog {
    @Override
    Transport creteTransport() {
        return new Truck();
    }
}
