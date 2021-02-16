package application;

import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int id = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        // TODO: this y/n question is bad, I know. Will fix soon. Just testing for now.
        System.out.print("Is there an initial deposit? (y/n) ");
        char answer = sc.next().charAt(0);

        BankAccount account;

        if(answer == 'y' || answer == 'Y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new BankAccount(id, holder, initialDeposit);
        }
        else {
            account = new BankAccount(id, holder);
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        account.deposit(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        account.withdraw(sc.nextDouble());

        System.out.println("Updated account data:");
        System.out.println(account);


    }
}
