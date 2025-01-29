package DesignPatterns.Behavorial.State.example2;

// Context Class
class DocumentContext {
    private DocumentState state;

    public DocumentContext() {
        state = new DraftState(); // Initial state
    }

    public void setState(DocumentState state) {
        this.state = state;
    }

    public void handleRequest() {
        state.handleRequest();
    }

    public void nextState() {
        state.nextState(this);
    }
}