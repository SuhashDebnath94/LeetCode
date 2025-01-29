package DesignPatterns.Behavorial.ObserverPattern.example1;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable{
    List<Observer> subscribers=new ArrayList<>();
    private int temperature;

    @Override
    public boolean add(Observer observer) {
        subscribers.add(observer);
        return true;
    }

    @Override
    public boolean remove(Observer observer) {
        subscribers.remove(observer);
        return true;
    }

    @Override
    public void notifyObservers() {
        this.subscribers.stream().forEach(subscriber ->{
            subscriber.update(this.temperature);
        });
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
}
