package DesignPatterns.Structural.FacadePattern;

class BankingFacade {
    private AccountsService accountService;
    private LoanService loanService;
    private CreditService creditService;

    public BankingFacade() {
        this.accountService = new AccountsService();
        this.loanService = new LoanService();
        this.creditService = new CreditService();
    }

    public boolean isEligibleForLoan(String accountId) {
        System.out.println("Checking loan eligibility for account: " + accountId);
        return accountService.checkAccount(accountId) &&
                loanService.hasNoLoans(accountId) &&
                creditService.hasGoodCredit(accountId);
    }
}