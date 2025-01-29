package DesignPatterns.Structural.AdaptorPAttern;

public class Driver {
    public static void main(String[] args) {
        LegacyTemperatureProducer legacyProvider = new LegacyTemperatureProducer();
        TemperatureProvider adapter = new TemperatureAdapter(legacyProvider);

        System.out.println("Temperature in Celsius: " + adapter.getTemperatureInCelsius());
    }
}
