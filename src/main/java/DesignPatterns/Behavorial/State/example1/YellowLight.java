package DesignPatterns.Behavorial.State.example1;

// Concrete State: Yellow Light
class YellowLight implements TrafficLightState {
    @Override
    public void display() {
        System.out.println("Caution! The light is YELLOW.");
    }

    @Override
    public void nextState(TrafficLightContext context) {
        context.setState(new RedLight());
    }
}