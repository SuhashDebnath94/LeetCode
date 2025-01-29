package DesignPatterns.Structural.BridgePattern.example1;

// Refined Abstraction: Advanced Remote
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        System.out.println("Advanced Power Control:");
        device.turnOn();
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Advanced Volume Control:");
        device.setVolume(volume);
    }

    public void mute() {
        System.out.println("Device is muted");
        device.setVolume(0);
    }
}