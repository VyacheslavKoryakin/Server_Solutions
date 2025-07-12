package org.example.Patterns.Structured.Bridge;

public class Triangle implements Shape {
    Color color;
    int length1;
    int length2;
    int length3;

    public Triangle(int length1, int length2, int length3) {
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color=" + color +
                ", length1=" + length1 +
                ", length2=" + length2 +
                ", length3=" + length3 +
                '}';
    }

    @Override
    public void create(Color color) {
        this.color = color.getColor();
    }

    @Override
    public Triangle getShape() {
        return this;
    }
}
