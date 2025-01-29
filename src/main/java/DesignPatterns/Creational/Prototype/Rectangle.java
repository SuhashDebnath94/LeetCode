package DesignPatterns.Creational.Prototype;

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.width, this.height); // Clone with the same dimensions
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width " + width + " and height " + height);
    }
}