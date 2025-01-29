package DesignPatterns.Structural.BridgePattern.example2;

// Concrete Implementor: Vector Renderer
class VectorRenderer implements Renderer {
    @Override
    public void render(String shape) {
        System.out.println("Drawing " + shape + " as vectors.");
    }
}