package DesignPatterns.Behavorial.ChainOfResponsibility;

class SupportStaff extends SupportHandler {
    @Override
    public void handleRequest(String issue, String severity) {
        if (severity.equalsIgnoreCase("low")) {
            System.out.println("Support Staff: Resolved the issue: " + issue);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Support Staff: Unable to resolve the issue: " + issue);
        }
    }
}