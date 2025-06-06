package org.example.Patterns.FactoryMethod;

public class ShipDialog extends Dialog{
    @Override
    Transport creteTransport() {
        return new Ship();
    }
}
