package entities;

public final class SavingsAccount extends Account {
    // final class = cannot be inherited;
    // final method() = cannot suffer @Override

    protected Double interestRate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(Integer idNumber, String holder, Double balance, Double interestRate) {
        super(idNumber, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public final void updateBalance() {
        balance += balance * interestRate;
        System.out.println("Updated interest! Balance now is $ "
                + String.format("%.2f", super.getBalance())
                + ", "
                + super.getIdNumber()
                + ", Holder: "
                + super.getHolder());
    }

    @Override // Account
    public void withdraw(double amount) {
        balance -= amount; // no fees on SavingsAccount
    }
}
