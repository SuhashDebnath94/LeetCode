package DesignPatterns.Behavorial.Visitor.example2;

// Element Interface
interface Item {
    int accept(CartVisitor visitor);
}