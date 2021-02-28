package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        List<Product> list1 = new ArrayList<>();

        list1.add(new Product("TV", 900.00));
        list1.add(new Product("Laptop", 1200.00));
        list1.add(new Product("Tablet", 450.00));

//        // Lambda statement
//        Comparator<Product> comp = (p1, p2) -> {
//            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//        };
//        // Or, because it's one line:
//        Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//
//        list1.sort(comp);
//
//        //Lambda expression
//        list1.sort((p1, p2) -> {
//            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
//        });

        // Or, because it's one line:
        list1.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list1) {
            System.out.println(p);
        }


    }
}
