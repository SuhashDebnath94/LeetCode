package DesignPatterns.Behavorial.Visitor.example1;

public class Driver {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 15);

        Visitor drawVisitor = new DrawVisitor();
        Visitor exportVisitor = new ExportVisitor();

        System.out.println("Drawing shapes:");
        circle.accept(drawVisitor);
        rectangle.accept(drawVisitor);

        System.out.println("\nExporting shapes:");
        circle.accept(exportVisitor);
        rectangle.accept(exportVisitor);
    }
}
