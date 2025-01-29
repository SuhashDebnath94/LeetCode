package DesignPatterns.Behavorial.State.example1;

// State Interface
interface TrafficLightState {
    void display();
    void nextState(TrafficLightContext context);
}