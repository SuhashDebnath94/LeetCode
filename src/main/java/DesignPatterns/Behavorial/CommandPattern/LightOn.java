package DesignPatterns.Behavorial.CommandPattern;

public class LightOn implements Command{
    private Light light;
    public LightOn(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        this.light.turnOn();
    }

    @Override
    public void unexecute() {
        this.light.turnOff();
    }
}
