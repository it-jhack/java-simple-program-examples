package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many tax payers will be registered? ");
        int n = sc.nextInt();

        List<TaxPayer> taxPayers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("#" + i + " TAX PAYER DATA");
            System.out.print("Individual or company (i/c)? ");
            char taxPayerType = sc.next().charAt(0);
            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();

            switch (taxPayerType) {
                case 'i':
                    System.out.print("Health expenses: ");
                    double healthExpenses = sc.nextDouble();
                    taxPayers.add(new Individual(name, annualIncome, healthExpenses));
                    break;
                case 'c':
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();
                    taxPayers.add(new Company(name, annualIncome, numberOfEmployees));
                    break;
            }
        }

        double totalTaxes = 0.0;

        System.out.println("\nTAXES PAID");
        for (TaxPayer tp: taxPayers) {
            System.out.println(tp.getName() + ": " + String.format("$ %,.2f", tp.tax()));
            totalTaxes += tp.tax();
        }

        System.out.print("\nTOTAL TAXES: " + String.format("$ %,.2f", totalTaxes));


        sc.close();
    }
}
