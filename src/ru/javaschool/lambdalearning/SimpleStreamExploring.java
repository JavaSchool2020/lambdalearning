package ru.javaschool.lambdalearning;

import java.util.stream.Stream;

public class SimpleStreamExploring {
    public static void main(String[] args) {
        long count = Stream.of("strawberry", "apple", "lemon", "lime").filter(v -> v.length() > 4).count();
        System.out.println("count is " + count);

        Stream<String> stream = Stream.of("strawberry", "apple", "lemon", "lime").filter(v -> v.length() > 4);
        System.out.println("count is " +stream.count());
        //System.out.println("count retry is " +stream.count());
    }
}
