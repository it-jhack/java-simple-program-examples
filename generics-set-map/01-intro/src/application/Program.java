package application;

import services.PrintService;

import java.util.Scanner;

public class Program {
    public void main (String[] args) {

        // Generics allow classes, interfaces and methods to be parameterized by type.
        // Benefits: reuse, type safety, performance.
        // Common use: collections.

        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        Integer x = ps.first();
        System.out.println("First: " + x);

        sc.close();

    }
}
