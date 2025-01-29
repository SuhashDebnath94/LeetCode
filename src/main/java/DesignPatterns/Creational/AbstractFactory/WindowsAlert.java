package DesignPatterns.Creational.AbstractFactory;

public class WindowsAlert implements Alert{
    @Override
    public void display() {
        System.out.println("This is Alert for Windows");
    }
}
