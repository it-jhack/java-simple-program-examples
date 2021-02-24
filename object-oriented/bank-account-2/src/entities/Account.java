package entities;

public class Account {

    protected Integer idNumber;
    protected String holder;
    protected Double balance;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance) {
        this.idNumber = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Integer idNumber) {
        this.idNumber = idNumber;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount + 3.00; // 3.00 == withdrawal fee;
        System.out.println("$ "
                + String.format("%.2f", amount)
                + " withdrew from account "
                + getIdNumber()
                + ", Holder: "
                + getHolder());
    }



}
