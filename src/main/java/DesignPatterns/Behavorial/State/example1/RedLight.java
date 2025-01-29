package DesignPatterns.Behavorial.State.example1;

// Concrete State: Red Light
class RedLight implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Stop! The light is RED.");
    }

    @Override
    public void nextState(TrafficLightContext context) {
        context.setState(new GreenLight());
    }
}