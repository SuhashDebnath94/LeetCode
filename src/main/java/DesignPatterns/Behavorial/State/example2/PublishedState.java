package DesignPatterns.Behavorial.State.example2;

// Concrete State: Published
class PublishedState implements DocumentState {
    @Override
    public void handleRequest() {
        System.out.println("Document is Published. It cannot be edited.");
    }

    @Override
    public void nextState(DocumentContext context) {
        System.out.println("The document is already published. No further state transitions.");
    }
}
