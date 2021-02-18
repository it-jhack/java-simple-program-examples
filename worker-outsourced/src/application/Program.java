package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees will you register? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + ":");

            System.out.print("Outsourced? (y/n) ");
            char outsourced = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine(); // consuming '\n' in the buffer
            String name = sc.nextLine();

            System.out.print("Worked hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (outsourced == 'y') {
                System.out.print("Additional charge: ");
                double addCharge = sc.nextDouble();

                employees.add(new OutsourcedEmployee(name, hours, valuePerHour, addCharge));
            }
            else {
                employees.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println("\nPAYMENTS:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }


        sc.close();
    }
}
