package application;

import java.util.HashMap;
import java.util.Map;

import entities.Product;

public class ProgramProduct {
    public static void main(String[] args) {

        Map<Product, Integer> stock = new HashMap<>();

        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        stock.put(p1, 10);
        stock.put(p2, 20);
        stock.put(p3, 15);

        Product ps = new Product("Tv", 900.0);

        for (Product key : stock.keySet()) {
            System.out.println(key + ": " + stock.get(key));
        }

        System.out.println("Contains 'ps' key: " + stock.containsKey(ps));
    }
}