package org.example.Patterns.Structured.Composite.Box;


import java.util.ArrayList;

public class Box implements BoxInterface {
    private ArrayList<BoxInterface> boxes = new ArrayList<>();

    public void add(BoxInterface boxInterface) {
        boxes.add(boxInterface);
    }

    @Override
    public void getPrice() {
        System.out.println("inside box:");
        for (BoxInterface boxInterface : boxes) {
            boxInterface.getPrice();
        }
    }
}