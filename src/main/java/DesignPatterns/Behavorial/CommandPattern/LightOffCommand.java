package DesignPatterns.Behavorial.CommandPattern;

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void unexecute() {
        light.turnOn();
    }
}