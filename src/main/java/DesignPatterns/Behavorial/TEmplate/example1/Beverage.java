package DesignPatterns.Behavorial.TEmplate.example1;

// Abstract Class
abstract class Beverage {
    // Template Method
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract Methods
    protected abstract void brew();
    protected abstract void addCondiments();
}