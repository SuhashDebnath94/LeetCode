package DesignPatterns.Creational.AbstractFactory;

public class LinuxFactory implements OSFactory{
    @Override
    public Button getButton() {
        return new LinuxButton();
    }

    @Override
    public Alert getAlert() {
        return new LinuxAlert();
    }
}
