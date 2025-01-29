package DesignPatterns.Creational.AbstractFactory;

public class MacButton implements Button{
    @Override
    public void display() {
        System.out.println("This is Button for Mac");
    }
}
