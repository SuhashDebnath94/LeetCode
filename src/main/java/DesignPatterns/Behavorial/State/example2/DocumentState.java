package DesignPatterns.Behavorial.State.example2;
// State Interface
interface DocumentState {
    void handleRequest();
    void nextState(DocumentContext context);
}
