package DesignPatterns.Behavorial.Visitor.example1;

// Visitor Interface
interface Visitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}