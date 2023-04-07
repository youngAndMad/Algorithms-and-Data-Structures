package danekerscode.FirstAssignment;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class FirstAssignment { // problem 10
    static BiConsumer<Integer, Integer> print = (n, m) -> IntStream.range(n, m + 1).forEach(
            num -> System.out.println(num + ((num & num - 1) == 0 ? " -is power of two" : " -is not power of two")));

    public static void main(String[] args) {
        print.accept(0, 32);
    }
}
