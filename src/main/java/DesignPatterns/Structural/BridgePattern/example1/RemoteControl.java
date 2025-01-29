package DesignPatterns.Structural.BridgePattern.example1;

// Abstraction
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();
    public abstract void setVolume(int volume);
}