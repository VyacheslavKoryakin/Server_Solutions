package org.example.Patterns.AbstractFactory;



public class Main {
    private static Factory configureFactory() {
        Factory factory;
        PhoneFactory phoneFactory = null;
        String phoneBrand = "Huawei";
        if (phoneBrand.equals("Huawei")) {
            phoneFactory = new HuaweiFactory();
        }else if (phoneBrand.equals("Samsung")) {
            phoneFactory = new SamsungFactory();
        }
        factory = new Factory(phoneFactory);
        return factory;
    }
    public static void main(String[] args) {

        Factory factory = configureFactory();
        factory.makePhone();
    }
}
