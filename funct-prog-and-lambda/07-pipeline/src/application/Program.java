package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {

        // PIPELINE EXAMPLES

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // .reduce(initial_element, function)
        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0) // all pair elements
                .map(x -> x * 10) // each pair will be multiplied by 10
                .collect(Collectors.toList()); // stream to list
        System.out.println(Arrays.toString(newList.toArray()));

    }
}
