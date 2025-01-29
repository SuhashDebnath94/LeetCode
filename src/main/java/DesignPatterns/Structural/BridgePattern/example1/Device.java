package DesignPatterns.Structural.BridgePattern.example1;

// Implementor Interface
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}