package DesignPatterns.Behavorial.ObserverPattern.example2;

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}