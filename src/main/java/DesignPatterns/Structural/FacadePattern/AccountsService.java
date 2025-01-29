package DesignPatterns.Structural.FacadePattern;

public class AccountsService {
    public boolean checkAccount(String accountId) {
        System.out.println("Checking account: " + accountId);
        return true; // Assume account is valid
    }
}
