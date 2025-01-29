package DesignPatterns.Behavorial.TEmplate.example2;

public class Driver {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVProcessor();
        DataProcessor jsonProcessor = new JSONProcessor();

        System.out.println("Processing CSV data:");
        csvProcessor.process();

        System.out.println("\nProcessing JSON data:");
        jsonProcessor.process();
    }
}
