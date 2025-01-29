package DesignPatterns.Behavorial.Visitor.example2;

// Concrete Element: Electronic
class Electronic implements Item {
    private String name;
    private int price;

    public Electronic(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int accept(CartVisitor visitor) {
        return visitor.visit(this);
    }
}