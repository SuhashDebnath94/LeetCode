package DesignPatterns.Behavorial.TEmplate.example2;

// Concrete Class: JSON Processor
class JSONProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("Processing JSON data");
    }
}