package DesignPatterns.Structural.AdaptorPAttern;

public class TemperatureAdapter implements TemperatureProvider {
    private LegacyTemperatureProducer legacyProvider;

    public TemperatureAdapter(LegacyTemperatureProducer legacyProvider) {
        this.legacyProvider = legacyProvider;
    }

    @Override
    public double getTemperatureInCelsius() {
        double fahrenheit = legacyProvider.getTemperatureInFahrenheit();
        return (fahrenheit - 32) * 5 / 9; // Convert Fahrenheit to Celsius
    }
}