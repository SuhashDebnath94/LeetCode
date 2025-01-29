package DesignPatterns.Behavorial.CommandPattern;

class ThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temperature;
    private int previousTemperature;

    public ThermostatCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        previousTemperature = temperature; // Simulate storing the last state
        thermostat.setTemperature(temperature);
    }

    @Override
    public void unexecute() {
        thermostat.setTemperature(previousTemperature);
    }
}