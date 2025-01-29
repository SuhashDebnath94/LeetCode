package DesignPatterns.Behavorial.Visitor.example1;

// Element Interface
interface Shape {
    void accept(Visitor visitor);
}