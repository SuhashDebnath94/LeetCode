package DesignPatterns.Behavorial.Visitor.example1;
// Concrete Element: Rectangle
class Rectangle implements Shape {
    private int width, height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}