package org.example.Patterns.FactoryMethod;

abstract class Dialog {
    public Transport renderTransport() {
        Transport transport = creteTransport();
        transport.render();
        return transport;
    }
    abstract Transport creteTransport();
}
