package DesignPatterns.Structural.BridgePattern.example2;

// Refined Abstraction: Circle
class Circle extends Shape {
    public Circle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Circle");
    }
}