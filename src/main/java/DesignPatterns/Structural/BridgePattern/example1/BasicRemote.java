package DesignPatterns.Structural.BridgePattern.example1;

// Refined Abstraction: Basic Remote
class BasicRemote extends RemoteControl {
    private boolean isOn = false;

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if (isOn) {
            device.turnOff();
        } else {
            device.turnOn();
        }
        isOn = !isOn;
    }

    @Override
    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}