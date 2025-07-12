package org.example.Patterns.Structured.Bridge;

public class Square implements Shape {
    Color color;
    int sideLength;

    public Square(int sideLength) {

        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "color=" + color +
                ", sideLength=" + sideLength +
                '}';
    }

    @Override
    public void create(Color color) {
        this.color = color.getColor();
    }

    @Override
    public Square getShape() {
        return this;
    }


}

