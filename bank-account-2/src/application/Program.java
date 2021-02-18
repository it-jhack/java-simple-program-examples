package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Account acc = new Account(1001, "Alex", 100.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 200.0, 500.0);

        // UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 200.0);
        Account acc3 = new SavingsAccount(1004, "Anna", 500.0, 0.01);

        // DOWNCASTING
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.loan(100.0);
            // You cannot do loan for acc2, first you have do downcast it to BusinessAccount

        // BusinessAccount acc5 = (BusinessAccount) acc3;
            // note acc3 is SavingsAccount, so despite the compiler not complaining,
            // this would return an error when executed.
        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.loan(200.0);
        }
        else if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount) acc3;
            acc5.updateBalance();
        }

        acc.withdraw(20);
        System.out.println("acc = " + acc.getBalance());

        bacc.withdraw(20);
        System.out.println("bacc = " + bacc.getBalance());

        acc1.withdraw(20);
        System.out.println("acc1 = " + acc1.getBalance());

        acc2.withdraw(20);
        System.out.println("acc2 = " + acc2.getBalance());

        acc3.withdraw(20);
        System.out.println("acc3 = " + acc3.getBalance());

        acc4.withdraw(20);
        System.out.println("acc4 = " + acc4.getBalance());

        //acc5.withdraw(20);
        //System.out.println("acc5 = " + acc5.getBalance());
            // Cannot be done because acc5 is out of scope.


    }

}
