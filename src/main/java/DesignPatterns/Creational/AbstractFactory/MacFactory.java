package DesignPatterns.Creational.AbstractFactory;

public class MacFactory implements OSFactory{
    @Override
    public Button getButton() {
        return new MacButton();
    }

    @Override
    public Alert getAlert() {
        return new MacAlert();
    }
}
