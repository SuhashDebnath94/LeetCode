package DesignPatterns.Structural.FacadePattern;

public class CreditService {
    public boolean hasGoodCredit(String accountId) {
        System.out.println("Checking credit score for account: " + accountId);
        return true; // Assume good credit
    }
}
