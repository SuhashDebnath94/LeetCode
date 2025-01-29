package DesignPatterns.Structural.BridgePattern.example2;

public class Driver {
    public static void main(String[] args) {
        Renderer vectorRenderer = new VectorRenderer();
        Renderer rasterRenderer = new RasterRenderer();

        Shape circle = new Circle(vectorRenderer);
        Shape rectangle = new Rectangle(rasterRenderer);

        circle.draw();
        rectangle.draw();
    }
}
