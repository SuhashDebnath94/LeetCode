package DesignPatterns.Behavorial.Mediator.example1;

//MEdiator Interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}
