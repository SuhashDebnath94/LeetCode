package DesignPatterns.Behavorial.State.example1;

public class Driver {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        for (int i = 0; i < 6; i++) {
            trafficLight.display();
            trafficLight.nextState();
        }
    }
}
