package DesignPatterns.Structural.FacadePattern;

public class LoanService {
    public boolean hasNoLoans(String accountId) {
        System.out.println("Checking loan status for account: " + accountId);
        return true; // Assume no loans
    }
}
