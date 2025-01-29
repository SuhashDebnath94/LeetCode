package DesignPatterns.Behavorial.Visitor.example2;

// Concrete Element: Book
class Book implements Item {
    private String title;
    private int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
}