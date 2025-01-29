package DesignPatterns.Creational.AbstractFactory;

public class WindowsButton implements Button{
    @Override
    public void display() {
        System.out.println("This is Button for Windows");
    }
}
