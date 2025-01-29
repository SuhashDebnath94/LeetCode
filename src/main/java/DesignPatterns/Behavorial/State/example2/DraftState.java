package DesignPatterns.Behavorial.State.example2;

// Concrete State: Draft
class DraftState implements DocumentState {
    @Override
    public void handleRequest() {
        System.out.println("Document is in Draft state. Edit content as needed.");
    }

    @Override
    public void nextState(DocumentContext context) {
        context.setState(new ModerationState());
    }
}
