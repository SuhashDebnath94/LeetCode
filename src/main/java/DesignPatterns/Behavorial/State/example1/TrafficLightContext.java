package DesignPatterns.Behavorial.State.example1;

// Context Class
class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        state = new RedLight(); // Initial state
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void display() {
        state.display();
    }

    public void nextState() {
        state.nextState(this);
    }
}