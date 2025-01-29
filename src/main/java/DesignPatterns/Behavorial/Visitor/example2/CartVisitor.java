package DesignPatterns.Behavorial.Visitor.example2;

interface CartVisitor {
    int visit(Book book);
    int visit(Electronic electronic);
}