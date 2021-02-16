package entities;

public class BankAccount {

    private int id;
    private String holder;
    private double balance;

    public BankAccount(int id, String holder, double balance) {
        this.id = id;
        this.holder = holder;
        this.balance = balance;
    }

    public BankAccount(int id, String holder) {
        this.id = id;
        this.holder = holder;
    }

    public int getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder){
        this.holder = holder;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account "
                + id
                + ", Holder: "
                + holder
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
