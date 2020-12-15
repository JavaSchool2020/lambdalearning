package ru.javaschool.lambdalearning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Stream;

public class CreateStreamExploring {
    static int i = 3;
    public static void main(String[] args) {
        Stream.generate(Random::new).limit(5).peek(System.out::println).count();
        Stream.iterate(1, n -> {
                    i++;
                    System.out.println("i = " + i);
                    System.out.println("n = " + n);
                    return n+1+i;
                })
                .limit(6).peek(System.out::println).count();

        Collection<String> collections = Arrays.asList("apple", "lemon", "strawberry", "lime");
        collections.stream().limit(3).forEach(System.out::println);

        Stream.empty().limit(2).count();

        Stream.Builder<String> builder = Stream.builder();
        Stream<String> streamWithBuilder = builder.add("apple").add("lime").build();
    }
}
