package DesignPatterns.Creational.AbstractFactory;

public class WindowsFactory implements OSFactory{
    @Override
    public Button getButton() {
        return new WindowsButton();
    }

    @Override
    public Alert getAlert() {
        return new WindowsAlert();
    }
}
