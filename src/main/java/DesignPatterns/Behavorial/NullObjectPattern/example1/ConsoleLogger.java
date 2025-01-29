package DesignPatterns.Behavorial.NullObjectPattern.example1;

// Real Logger (RealObject)
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Logging message: " + message);
    }
}