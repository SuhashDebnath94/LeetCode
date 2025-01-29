package DesignPatterns.Creational.AbstractFactory;

public class Driver {
    public static void main(String[] args) {
        OSFactory factory = new MacFactory();
        factory.getAlert().display();
        factory.getButton().display();
    }
}
