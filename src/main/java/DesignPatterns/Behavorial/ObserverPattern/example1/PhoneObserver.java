package DesignPatterns.Behavorial.ObserverPattern.example1;

public class PhoneObserver implements Observer{
    private int temperature;
    public void displayTemp(){
        System.out.println(this.temperature);
    }

    @Override
    public void update(int temperature) {
        this.temperature=temperature;
    }
}
