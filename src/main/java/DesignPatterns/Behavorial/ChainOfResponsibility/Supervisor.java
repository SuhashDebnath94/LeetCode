package DesignPatterns.Behavorial.ChainOfResponsibility;

class Supervisor extends SupportHandler {
    @Override
    public void handleRequest(String issue, String severity) {
        if (severity.equalsIgnoreCase("medium")) {
            System.out.println("Supervisor: Resolved the issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Supervisor: Unable to resolve the issue: " + issue);
        }
    }
}