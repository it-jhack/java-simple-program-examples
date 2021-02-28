package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {


//        ------------------------
//                STREAM
//        ------------------------
        {
        /*

        -A sequence of elements coming from a data source that
          supports "aggregated operations".
        Data source exs: collection, array, iteration function,
          I/O resources.

        -A solution to process form data sequences
          -Declarative (internal iteration: hidden from programmer)
          -Parallel-friendly (immutable -> thread safe)
          -No collateral effect
          -On demand (lazy evaluation)

        -Sequential access (no index available)

        -Single-use (only used once)

        -Pipeline: stream operations return new streams. So, it's
          possible to create a chain of operations flow.


        INTERMEDIARY AND TERMINAL OPERATIONS

        Pipeline is made of zero or more intermediary operations and
          + one terminal operation.

        Intermediary Operations:
            -Produces a new stream (chaining)
            -Only executes when a terminal operation is summoned
              (lazy evaluation)
            Exs: filter, map, flatmap, peek, distinct, sorted, skip, limit(*)
              * short-circuit == limit(10) will 'short-circuit'/be cut at
              10th element.

        Terminal Operations:
            -Produces a non-stream object (collection or other)
            -Determines the end of stream processing (hence, "terminal")
            Exs: forEach, forEachOrdered, toArray, reduce, collect, min,
                 max, count, anyMatch(*), allMatch(*), noneMatch(*),
                 findFirst(*), findAny(*)
              * short-circuit


        Creating a Stream
        -Call stream() or parallelStream() from any Collection object.
        -Other ways:
            Stream.of
            Stream.ofNullable
            Stream.iterate

        */
        }

        List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        Stream<Integer> st1 = list.stream().map(x -> x * 10); // stream = list * 10
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2); // potentially infinite
        System.out.println(Arrays.toString(st3.limit(10).toArray())); // ends at 10th element

        // Fibonacci sequence
        Stream<Long> st4 = Stream.iterate(
                new long[]{ 0L, 1L }, // first element/Java Tuples life-hack
                p -> new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray())); // stops at 10th element



    }
}
