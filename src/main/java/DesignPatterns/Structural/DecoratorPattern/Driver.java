package DesignPatterns.Structural.DecoratorPattern;

public class Driver {
    public static void main(String[] args) {

        Beverage coffee=new Caramel(new Caramel(new Coffee()));
        System.out.println(coffee.cost());
    }
}
