package DesignPatterns.Structural.DecoratorPattern;

public class Coffee implements Beverage{
    int cost=5;
    @Override
    public int cost() {
        return this.cost;
    }
}
