package DesignPatterns.Behavorial.Visitor.example1;

// Concrete Visitor: Draw Operation
class DrawVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Drawing a Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Drawing a Rectangle with width: " + rectangle.getWidth() +
                ", height: " + rectangle.getHeight());
    }
}