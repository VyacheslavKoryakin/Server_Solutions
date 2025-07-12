package org.example.Patterns.Structured.Bridge;



public class Main {


    public static void main(String[] args) {
        MyColor myColor = new MyColor("Blue");
        Triangle triangle = new Triangle(10,15,25);
        Square square = new Square(10);


        square.create(myColor.getColor());


        myColor = new MyColor("Red");
        triangle.create(myColor.getColor());

        System.out.println(square.getShape());
        System.out.println(triangle.getShape());

    }
}
