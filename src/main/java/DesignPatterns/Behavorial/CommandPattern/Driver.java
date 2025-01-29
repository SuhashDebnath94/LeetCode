package DesignPatterns.Behavorial.CommandPattern;

public class Driver {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new LightOn(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command setThermostat = new ThermostatCommand(thermostat, 22);

        RemoteControl remote = new RemoteControl();

        // Turn the light on
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn the light off
        remote.setCommand(lightOff);
        remote.pressButton();

        // Adjust the thermostat
        remote.setCommand(setThermostat);
        remote.pressButton();

        // Undo the last action (Thermostat)
        remote.pressUndo();
    }
}
