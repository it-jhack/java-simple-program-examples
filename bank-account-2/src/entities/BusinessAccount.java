package entities;

public class BusinessAccount extends Account {

    protected Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer idNumber, String holder, Double balance, Double loanLimit) {
        super(idNumber, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if(amount <= loanLimit) {
            deposit(amount);
            System.out.println("$ "
                    + String.format("%.2f", amount)
                    + " loan granted on account "
                    + super.getIdNumber()
                    + ", Holder: "
                    + super.getHolder());
        }
    }

    @Override // Account
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.00; // extra 2.00 fee for BusinessAccount
    }

}
