package ru.javaschool.lambdalearning;

import ru.javaschool.lambdalearning.model.Bill;
import ru.javaschool.lambdalearning.model.Sum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExploring {
    public static void main(String[] args) {

        String[] fruits = {"strawberry", "apple", "lemon", "lime"};

        Stream<String> fruit = Stream.of(fruits)
                .peek(System.out::println)
                .sorted()
                .filter(v -> v.length() > 4)
                .peek(System.out::println);

        long count2 = fruit.count();

        System.out.println("count2 is " + count2);

        int sum = Stream.of(fruits)
                .map(String::length)
                .filter(v -> v > 4)
                .reduce(0, Integer::sum);

        System.out.println("sum is " + sum);

        int sum2 = Stream.of(fruits)
                .map(String::length)
                .filter(v -> v > 4)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("sum2 is " + sum2);

        List<String> fruitCollection = Arrays.asList(fruits);
        fruitCollection.stream().map("!"::concat).peek(System.out::println).filter(f -> f.length() > 4);//.count();

        System.out.println(fruit);

        System.out.println("Count " + new StreamExploring().buildBillsArrayList().stream()
                .peek(bill -> System.out.println("each " + bill))
                .filter(bill -> bill.getSum().getAmount().compareTo(new BigDecimal(100)) >= 0)
                .peek(System.out::println)
                .count());

        System.out.println("Max " + new StreamExploring().buildBillsArrayList().stream()
                .peek(bill -> System.out.println(bill.getPerson().getName() + ", summary "
                        + bill.getSum().getAmount()))
                .map(Bill::getSum)
                .map(Sum::getAmount)
                .max(BigDecimal::compareTo));
    }


    public List<Bill> buildBillsArrayList() {
        Bill bill1 = new Bill("Vasya", new BigDecimal("100"));
        List<Bill> bills = new ArrayList<>(2);
        bills.add(bill1);
        bills.add(new Bill("Konstantin", new BigDecimal("150")));
        bills.add(new Bill("Vasya", new BigDecimal("100")));

        return bills;
    }
}
