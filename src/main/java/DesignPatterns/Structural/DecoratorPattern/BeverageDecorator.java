package DesignPatterns.Structural.DecoratorPattern;

public abstract class BeverageDecorator implements Beverage{
    Beverage beverage;
    public BeverageDecorator(Beverage beverage){
        this.beverage=beverage;
    }
    public abstract int cost();
}
