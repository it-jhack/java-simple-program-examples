package application;

import entities.Product;
import model.services.ProductService;
import util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        // T = input
        // R = output
//        public interface Function<T, R> {
//            R apply(T t);
//        }

//        https://docs.oracle.com/javase/10/docs/api/java/util/function/Function.html

        // Do a program that from a list of product, generates a new list with products names in upper case.

        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("PC Case", 80.90));

        // map function (NOT to be confused with Map Data Structure) is a function that
        // applies another function to all stream (not list) elements.

        // To convert:
        // List to stream: .stream()
        // Stream to List: .collect(Collectors.toList())


//        // Converting list to stream to apply the function, then back to list, then storing as 'namesList'.
//        List<String> namesList = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

//        // Reference method with static method
//        List<String> namesList = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

//        // Reference method with non-static method
//        List<String> namesList = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

//         //Declared lambda expression
//        Function<Product, String> func = p -> p.getName().toUpperCase();
//        List<String> namesList = list.stream().map(func).collect(Collectors.toList());

        // Inline lambda expression
        List<String> namesList = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

        // Printing namesList
        namesList.forEach(System.out::println);


        System.out.println("--------------------------");

        // Converting Product list names to upper case:
        list.forEach(p -> p.setName(p.getName().toUpperCase()));

        // Printing
        list.forEach(System.out::println);


        System.out.println("--------------------------");
        System.out.println("Creating a function that receives another function as argument:");

        // Creating a function that receives another function as argument:

        // Calculate the price sum of products beginning with 'T':
        // model.services.ProductService


        List<Product> prodList = new ArrayList<>();

        prodList.add(new Product("Tv", 900.00));
        prodList.add(new Product("Mouse", 50.00));
        prodList.add(new Product("Tablet", 350.50));
        prodList.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        // list, lambda_expression
        Character ch = 'T';
        double sum1 = ps.filteredSum(prodList, p -> p.getName().charAt(0) == ch);
        System.out.println("Sum1 = " + String.format("%.2f", sum1));

        double limitPrice = 100.0;
        double sum2 = ps.filteredSum(prodList, p -> p.getPrice() <= 100.0);
        System.out.println("Sum2 = " + String.format("%.2f", sum2));

    }
}
