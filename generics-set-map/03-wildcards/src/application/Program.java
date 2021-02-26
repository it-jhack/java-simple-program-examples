package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        // You can
        Integer x = 10;
        Object obj = x;

        // But you can't
//        List<Integer> myNumbers = new ArrayList<Integer>();
//        List<Object> myObjs = new ArrayList<Object>();
//        myObjs = myNumbers;

        // Wildcard: List<?>
        List<?> myObjs = new ArrayList<Object>();
        List<Integer> myNumbers = new ArrayList<Integer>();
        myObjs = myNumbers;

        // With Wildcards, we can create methods that receive a generic of any type
        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printList(myInts);

        // IMPORTANT: you CANNOT add data to a wildcard collection
        //list.add(3) //this would return an error, because
        // the compiler doesn't know which specific type you list was instantiated

    }// END OF MAIN

    // method with wildcard
    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
