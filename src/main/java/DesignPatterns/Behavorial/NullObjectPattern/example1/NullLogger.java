package DesignPatterns.Behavorial.NullObjectPattern.example1;

// Null Logger (NullObject)
class NullLogger implements Logger {
    @Override
    public void log(String message) {
        // Do nothing
    }
}