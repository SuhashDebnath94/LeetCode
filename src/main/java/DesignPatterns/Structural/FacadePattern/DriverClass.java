package DesignPatterns.Structural.FacadePattern;

public class DriverClass {
    public static void main(String[] args) {
        BankingFacade bankingFacade = new BankingFacade();
        String accountId = "12345";

        if (bankingFacade.isEligibleForLoan(accountId)) {
            System.out.println("Loan approved for account: " + accountId);
        } else {
            System.out.println("Loan denied for account: " + accountId);
        }
    }
}
