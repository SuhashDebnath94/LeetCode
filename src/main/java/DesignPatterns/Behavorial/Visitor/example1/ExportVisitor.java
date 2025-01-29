package DesignPatterns.Behavorial.Visitor.example1;

// Concrete Visitor: Export Operation
class ExportVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Exporting Circle to SVG with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Exporting Rectangle to SVG with width: " + rectangle.getWidth() +
                ", height: " + rectangle.getHeight());
    }
}