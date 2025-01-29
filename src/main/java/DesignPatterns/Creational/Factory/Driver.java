package DesignPatterns.Creational.Factory;

public class Driver {
    public static void main(String[] args) {
        AnimalFactory animalFactory=new AnimalFactory();
        Animal dog=animalFactory.getAnimal("dog");
        dog.makeSound();
    }
}
