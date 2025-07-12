package org.example.Patterns.Structured.Bridge;

public class MyColor implements Color {

    private String color;


    protected MyColor(String color) {
        this.color = color;
    }


    @Override
    public Color getColor() {
        return this;
    }

    @Override
    public String toString() {
        return color;

    }
}
