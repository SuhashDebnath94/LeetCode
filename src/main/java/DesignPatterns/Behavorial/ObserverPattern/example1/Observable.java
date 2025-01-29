package DesignPatterns.Behavorial.ObserverPattern.example1;

public interface Observable {
    public boolean add(Observer observer);
    public boolean remove(Observer observer);
    public void notifyObservers();
}
