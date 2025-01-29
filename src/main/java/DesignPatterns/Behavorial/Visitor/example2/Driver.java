package DesignPatterns.Behavorial.Visitor.example2;

public class Driver {
    public static void main(String[] args) {
        Item book = new Book("Design Patterns", 500);
        Item laptop = new Electronic("Laptop", 1500);
        CartVisitor priceCalculator = new PriceCalculator();
        int totalCost = book.accept(priceCalculator) + laptop.accept(priceCalculator);
        System.out.println("Total cost: " + totalCost);
    }
}
