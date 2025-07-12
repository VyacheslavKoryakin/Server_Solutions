package org.example.Patterns.Structured.Composite.Main;

import org.example.Patterns.Structured.Composite.Box.Box;
import org.example.Patterns.Structured.Composite.Product.Phone;
import org.example.Patterns.Structured.Composite.Product.Watch;

public class Main {
    public static void main(String[] args) {


        Phone phone1 = new Phone("Huawei","P30", 28000);
        Phone phone2 = new Phone("Samsung","S24", 73000);
        Watch watch = new Watch("Apple", 19000);
        Box phoneBox = new Box();
        phoneBox.add(phone1);
        phoneBox.add(phone2);
        Box watchBox = new Box();
        watchBox.add(watch);
        Box box = new Box();
        box.add(phoneBox);
        box.add(watchBox);
        box.getPrice();



    }
}
