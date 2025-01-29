package DesignPatterns.Behavorial.State.example2;

public class Driver {
    public static void main(String[] args) {
        DocumentContext document = new DocumentContext();

        document.handleRequest();
        document.nextState();

        document.handleRequest();
        document.nextState();

        document.handleRequest();
        document.nextState();
    }
}
