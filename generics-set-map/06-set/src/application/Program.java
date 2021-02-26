package application;

import entities.Product;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String[] args) {

        // Set<T>
//         -No repetitions
//         -No element positions
//         -Quickly add/remove elements
//         -Offers efficient set operations: intersection, union, difference.

        // Main usage:
//         -HashSet: faster - O(1) hash table operations - and not ordinated
//         -TreeSet: slower - O(log(n)) in Red-Black tree operations - and
//             ordinated by object's compareTo (Comparator)
//         -LinkedHashSet: medium speed. Elements in added order.

        // Some important Methods:
//        • add(obj), remove(obj), contains(obj)
//            • based on equals e hashCode
//            • If equals and hashCode do not exist, pointers comparison is used
//        • clear()
//        • size()
//        • removeIf(predicate)
//        • addAll(other) - union: adds to the set, the elements from 'other' set, without repetitions.
//        • retainAll(other) - intersection: removes from set the elements NOT contained in 'other'.
//        • removeAll(other) - difference: removes from set the elements contained in 'other'.

        Set<String> set1 = new HashSet<>();

        set1.add("TV");
        set1.add("Notebook");
        set1.add("Tablet");

        System.out.println(set1.contains("Notebook"));

        for (String p : set1) {
            System.out.println(p);
        }


        System.out.println("#1 ----------------------------------------");


        set1.removeIf( x -> x.charAt(0) == 'T');

        for (String p : set1) {
            System.out.println(p);
        }


        System.out.println("#2 ----------------------------------------");


        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(5,6,7,8,9,10));

        //union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        //intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        //difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);


        System.out.println("#3 ----------------------------------------");


        // How Hash collections test equality?
//        • If hashCode and equals are already implemented:
//            • First hashCode(). If it's the same, confirm with equals().
//            • Remember: String, Integer, Double, etc. already have equals() and hashCode()
//        • If hashCode and equals are NOT implemented:
//            • Compares objects' pointer references.

        Set<Product> set2 = new HashSet<>();

        set2.add(new Product("TV", 900.0));
        set2.add(new Product("Notebook", 1200.0));
        set2.add(new Product("Tablet", 400.0));

        Product prod = new Product("Notebook", 1200.0);

        System.out.println(set2.contains(prod)); // true because hashCode() and equals() (@Overrides) in Product


        System.out.println("#4 ----------------------------------------");


        Set<Product> set3 = new TreeSet<>();

        set3.add(new Product("TV", 900.0));
        set3.add(new Product("Notebook", 1200.0));
        set3.add(new Product("Tablet", 400.0));

        for (Product p : set3) {
            System.out.println(p);
        }

    }
}
