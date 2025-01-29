package DesignPatterns.Structural.Flyweight.example2;

// Concrete Flyweight
class TreeFlyweight implements Tree {
    private final String type; // Intrinsic state
    private final String color;
    private final String texture;

    public TreeFlyweight(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void display(int x, int y) {
        System.out.println("Tree [Type=" + type + ", Color=" + color + ", Texture=" + texture +
                "] at (" + x + ", " + y + ")");
    }
}