package DesignPatterns.Behavorial.State.example2;

// Concrete State: Moderation
class ModerationState implements DocumentState {
    @Override
    public void handleRequest() {
        System.out.println("Document is under Moderation. Review content.");
    }

    @Override
    public void nextState(DocumentContext context) {
        context.setState(new PublishedState());
    }
}