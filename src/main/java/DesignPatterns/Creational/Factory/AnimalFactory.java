package DesignPatterns.Creational.Factory;

public class AnimalFactory {
    public Animal getAnimal(String animal){
        if(animal.equals("Cat")) return new Cat();
        else return new Dog();
    };
}
