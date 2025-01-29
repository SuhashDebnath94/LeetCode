package DesignPatterns.Structural.DecoratorPattern;

public class Caramel extends BeverageDecorator{

    private int cost=2;
    public Caramel(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return this.beverage.cost()+this.cost;
    }

}
