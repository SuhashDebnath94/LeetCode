package DesignPatterns.Behavorial.ObserverPattern.example2;

public class Driver {
    // Client
        public static void main(String[] args) {
            Stock google = new Stock("Google", 1500);
            StockObserver investor1 = new StockObserver("Investor1");
            StockObserver investor2 = new StockObserver("Investor2");

            google.attach(investor1);
            google.attach(investor2);

            google.setPrice(1520); // Notify all observers
            google.setPrice(1550); // Notify all observers
        }

}
