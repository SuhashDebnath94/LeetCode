package DesignPatterns.Structural.BridgePattern.example1;

public class Driver {
    public static void main(String[] args) {
        Device tv = new TV();
        Device radio = new Radio();

        RemoteControl basicRemote = new BasicRemote(tv);
        RemoteControl advancedRemote = new AdvancedRemote(radio);

        basicRemote.togglePower();
        basicRemote.setVolume(15);

        advancedRemote.togglePower();
        advancedRemote.setVolume(20);
        ((AdvancedRemote) advancedRemote).mute();
    }
}
