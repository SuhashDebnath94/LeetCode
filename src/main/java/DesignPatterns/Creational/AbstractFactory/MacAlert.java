package DesignPatterns.Creational.AbstractFactory;

public class MacAlert implements Alert{
    @Override
    public void display() {
        System.out.println("This is Alert for Mac");
    }
}
