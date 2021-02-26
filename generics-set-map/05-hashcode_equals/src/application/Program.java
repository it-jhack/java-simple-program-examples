package application;

import entities.Client;

public class Program {
    public static void main(String[] args) {

        // equals(): slow, 100% accuracy

        // hashCode(): fast, not 100% accurate.
        // With 77,163 different objects, you have a 50% chance of collision.
        // Birthday Paradox: 367 people to have 100% chance collision, 70 people = 99.9%, 23 people = 50%.
        // .
        // The Enron email dataset contains 520,924 emails. Computing the String hash codes of the
        // email contents, the author found 50 pairs (and even 2 triples) of different emails with
        // the same hash code.
        // Source: https://eclipsesource.com/blogs/2012/09/04/the-3-things-you-should-know-about-hashcode/

        // GOLDEN RULE:
        // Same hashCode, NOT necessarily same object.
        // Different hash codes = different objects (100% chance)

        // Common practice:
        // You query large databases for equal hashCode(), because it's way faster than equals().
        // If true, you confirm with equals().

        String a = "FB";
        String b = "Ea";

        System.out.println(a.equals(b));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Client c1 = new Client("Maria", "maria@gmail.com");
        Client c2 = new Client("Maria", "maria@gmail.com");

        System.out.print("c1.equals(c2) ");
        System.out.println(c1.equals(c2)); // compares content
        System.out.print("c1 == c2 ");
        System.out.println(c1 == c2); // compares memory reference

        String s1 = "test";
        String s2 = "test";
        System.out.print("s1 == s2 ");
        System.out.println(s1 == s2); // true because compiler treats 'Literals' in different manner

        String s3 = new String("test");
        String s4 = new String("test");
        System.out.print("s3 == s4 ");
        System.out.println(s3 == s4); // false

    }
}
