package DesignPatterns.Behavorial.NullObjectPattern.example1;

// Client
class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void execute(String message) {
        // No need for null checks, NullLogger handles the case when no logger is passed
        logger.log(message);
    }
}