package DesignPatterns.Behavorial.ChainOfResponsibility;

class Manager extends SupportHandler {
    @Override
    public void handleRequest(String issue, String severity) {
        if (severity.equalsIgnoreCase("high")) {
            System.out.println("Manager: Resolved the issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Manager: Unable to resolve the issue: " + issue);
        }
    }
}