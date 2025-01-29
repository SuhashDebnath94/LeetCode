package DesignPatterns.Behavorial.ObserverPattern.example2;

// Concrete Observer
class StockObserver implements Observer {
    private final String name;

    public StockObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println(name + " received update: " + stockName + " is now $" + stockPrice);
    }
}
