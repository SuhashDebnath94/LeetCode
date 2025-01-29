package DesignPatterns.Creational.Factory;

public class Dog implements Animal{

    @Override
    public void makeSound() {
        System.out.println("Bark Bark");
    }
}
