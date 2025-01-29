package DesignPatterns.Behavorial.TEmplate.example2;

// Abstract Class
abstract class DataProcessor {
    // Template Method
    public final void process() {
        loadData();
        processData();
        saveData();
    }

    private void loadData() {
        System.out.println("Loading data from source");
    }

    private void saveData() {
        System.out.println("Saving processed data to destination");
    }

    // Abstract Methods
    protected abstract void processData();
}