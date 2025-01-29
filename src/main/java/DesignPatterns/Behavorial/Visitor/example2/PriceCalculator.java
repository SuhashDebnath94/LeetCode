package DesignPatterns.Behavorial.Visitor.example2;

// Concrete Visitor: Price Calculator
class PriceCalculator implements CartVisitor {
    @Override
    public int visit(Book book) {
        int price = book.getPrice();
        System.out.println("Book: " + book.getTitle() + " costs " + price);
        return price;
    }

    @Override
    public int visit(Electronic electronic) {
        int price = electronic.getPrice();
        System.out.println("Electronic: " + electronic.getName() + " costs " + price);
        return price;
    }
}