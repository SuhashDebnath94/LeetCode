package DesignPatterns.Creational.AbstractFactory;

public class LinuxAlert implements Alert{
    @Override
    public void display() {
        System.out.println("This is Alert for Linux");
    }
}
