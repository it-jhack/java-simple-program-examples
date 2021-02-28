package application;

import entities.Product;
import util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Program {
    public static void main(String[] args) {

//        public interface Consumer<T> {
//            void accept(T t);
//        }

//        https://docs.oracle.com/javase/10/docs/api/java/util/function/Consumer.html

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("PC Case", 80.90));

        // Do a program that increase products price in 10%;

//        // Interface implementation
//        list.forEach(new PriceUpdate());

//        // Reference method with static method
//        list.forEach(Product::staticPriceUpdate);

//        // Reference method with non-static method
//        list.forEach(Product::nonStaticPriceUpdate);

//        // Declared lambda expression
//        double increaseFactor = 1.1;
//        Consumer<Product> cons = p -> p.setPrice(p.getPrice() * increaseFactor);
//        list.forEach(cons);

        // Inline lambda expression
        double increaseFactor = 1.1;
        list.forEach(p -> p.setPrice(p.getPrice() * increaseFactor));

        // Printing
        list.forEach(System.out::println);
    }
}
