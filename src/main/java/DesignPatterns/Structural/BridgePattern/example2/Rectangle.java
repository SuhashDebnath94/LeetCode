package DesignPatterns.Structural.BridgePattern.example2;

// Refined Abstraction: Rectangle
class Rectangle extends Shape {
    public Rectangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public void draw() {
        renderer.render("Rectangle");
    }
}
