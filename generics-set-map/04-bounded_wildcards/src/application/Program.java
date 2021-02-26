package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {

    public static void main(String[] args) {

        //#1 - Shapes example
        System.out.println("\n#1 - Shapes example");

        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(myCircles));


        //#2 - get/put principle
        System.out.println("\n#2 - get/put principle");

        // Now suppose you want to take an Integer and a Double List, then add them to an Object list.
        // We'll use the Number wrapper (it's between Object and Double, Integer, Float, etc.)

        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs); // method that copies myInts elements into myObjs list.
        printList(myObjs);

        copy(myDoubles, myObjs);
        printList(myObjs);

    }// end of main

    // #1 - Shapes example
    // '<? extends Shape>': it can be Shape or any subtypes of Shape
    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }

    // #2 - get/put principle
    // arg0 = Any subtype of Number (Number or more specific)
    // arg1 = Any super of Number (Number or more generic)
    public static void copy(List<? extends Number> source, List<? super Number> destination) {
        for (Number number : source) {
            destination.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }
}
/*
GET/PUT PRINCIPLE

    Covariance:

List<Integer> intList = new ArrayList<Integer>();
intList.add(10);
intList.add(5);
List<? extends Number> list = intList;
Number x = list.get(0);
list.add(20); // compilation error!

get = OK
put = ERROR


    Countervariance:

List<Object> myObjs = new ArrayList<Object>();
myObjs.add("Maria");
myObjs.add("Alex");
List<? super Number> myNums = myObjs;
myNums.add(10);
myNums.add(3.14);
Number x = myNums.get(0); // compilation error!

get = ERROR
put = OK
 */