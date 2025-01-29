package DesignPatterns.Behavorial.NullObjectPattern.example1;

public class Driver {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        Application appWithLogger = new Application(logger);
        appWithLogger.execute("This is a real log");

        Logger nullLogger = new NullLogger();
        Application appWithoutLogger = new Application(nullLogger);
        appWithoutLogger.execute("This log does nothing");
    }
}
