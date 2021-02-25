package application;

import java.util.Locale;
import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;

public class Program {

    public static void main(String[] args) {

        // Default Methods:
        // -Avoid repetition on classes implementations;
        // -Avoid the need to create an abstract class (to reuse implementation);
        // -Can have static and private methods;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        System.out.print("Months: ");
        int months = sc.nextInt();

        InterestService intServ = new BrazilInterestService(2.0);
        double payment = intServ.payment(amount, months);

        System.out.println("Payment after " + months + " months:");
        System.out.println(String.format("%.2f", payment));

        sc.close();
    }
}