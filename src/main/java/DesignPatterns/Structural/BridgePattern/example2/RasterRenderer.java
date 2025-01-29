package DesignPatterns.Structural.BridgePattern.example2;

// Concrete Implementor: Raster Renderer
class RasterRenderer implements Renderer {
    @Override
    public void render(String shape) {
        System.out.println("Drawing " + shape + " as pixels.");
    }
}