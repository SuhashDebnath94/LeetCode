package DesignPatterns.Behavorial.ChainOfResponsibility;

public class Driver {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler supportStaff = new SupportStaff();
        SupportHandler supervisor = new Supervisor();
        SupportHandler manager = new Manager();

        // Set up the chain
        supportStaff.setNextHandler(supervisor);
        supervisor.setNextHandler(manager);

        // Process requests
        supportStaff.handleRequest("Password reset", "low");
        supportStaff.handleRequest("System crash", "medium");
        supportStaff.handleRequest("Data breach", "high");
        supportStaff.handleRequest("Unresolved critical issue", "critical");
    }
}
