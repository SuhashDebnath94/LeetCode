package DesignPatterns.Creational.Prototype;

public class Driver {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 20);

        // Clone the shapes
        Shape clonedCircle = circle.clone();
        Shape clonedRectangle = rectangle.clone();

        // Draw the original and cloned shapes
        circle.draw();
        clonedCircle.draw();
        rectangle.draw();
        clonedRectangle.draw();
    }
}
