package DesignPatterns.Creational.Factory;

public class Cat implements Animal{
    @Override
    public void makeSound() {
        System.out.println("Meaow meaow");
    }
}
