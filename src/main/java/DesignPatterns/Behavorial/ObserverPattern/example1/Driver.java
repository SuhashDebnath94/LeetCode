package DesignPatterns.Behavorial.ObserverPattern.example1;

public class Driver {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        Observer phoneObserver = new PhoneObserver();
        Observer tvObserver = new TVObserver();
        ws.add(phoneObserver);
        ws.add(tvObserver);
        ws.setTemperature(57);
        phoneObserver.displayTemp();
        tvObserver.displayTemp();
        ws.setTemperature(49);
        phoneObserver.displayTemp();
        tvObserver.displayTemp();

    }
}
