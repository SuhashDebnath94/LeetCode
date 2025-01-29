package DesignPatterns.Structural.Flyweight.example2;

public class Driver {
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory();

        Tree oakTree = factory.getTree("Oak", "Green", "Smooth");
        oakTree.display(10, 20);

        Tree pineTree = factory.getTree("Pine", "Dark Green", "Rough");
        pineTree.display(15, 30);

        // Reusing the Oak tree flyweight
        Tree anotherOakTree = factory.getTree("Oak", "Green", "Smooth");
        anotherOakTree.display(25, 40);
    }
}
