package DesignPatterns.Behavorial.State.example1;

// Concrete State: Green Light
class GreenLight implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Go! The light is GREEN.");
    }

    @Override
    public void nextState(TrafficLightContext context) {
        context.setState(new YellowLight());
    }
}