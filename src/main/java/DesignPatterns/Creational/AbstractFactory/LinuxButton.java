package DesignPatterns.Creational.AbstractFactory;

public class LinuxButton implements Button{
    @Override
    public void display() {
        System.out.println("This is Button for Linux");
    }
}
