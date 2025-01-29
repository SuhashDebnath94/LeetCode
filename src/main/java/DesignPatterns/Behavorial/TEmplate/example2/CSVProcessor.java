package DesignPatterns.Behavorial.TEmplate.example2;

// Concrete Class: CSV Processor
class CSVProcessor extends DataProcessor {
    @Override
    protected void processData() {
        System.out.println("Processing CSV data");
    }
}