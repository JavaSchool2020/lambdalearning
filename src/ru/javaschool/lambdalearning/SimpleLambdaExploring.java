package ru.javaschool.lambdalearning;

import ru.javaschool.lambdalearning.model.BillTotalCalculator;

import java.io.FileFilter;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.function.Function;

public class SimpleLambdaExploring {
    String word = "Hello";
    public static void main(String[] args) {
        Comparator<String> myComparator = (o1, o2) -> o1.compareTo(o2);

        Runnable noArgument = () -> System.out.println("Hello World");

        Runnable multiStatement = () -> {
            System.out.println("Hello");
            System.out.println("World");
        };

        Function<Integer, Long> multiplyByTen = (x) -> x*10L;

        FileFilter containsHello = (file)  -> file.getName().contains("Hello");

        Function<Integer, Long> multiplyByTenExplicit = (Integer x) -> x*10L;

        Function<String, BigInteger> create = BigInteger::new;

        BigInteger bigInteger = create.apply("2");
        System.out.println(bigInteger);

        new SimpleLambdaExploring().multiStatement();
    }

    public void multiStatement() {
        word = "Hello!!!";
        Runnable multiStatement = () -> {
            System.out.println(word);
            System.out.println("World");
        };
    }
}
