package ru.javaschool.lambdalearning;

import ru.javaschool.lambdalearning.model.Bill;
import ru.javaschool.lambdalearning.model.BillTotalCalculator;
import ru.javaschool.lambdalearning.model.Person;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExploring {
    public static void main(String[] args) {
        String[] fruits = {"strawberry", "apple", "lemon", "lime"};

        List<String> list = Stream.of(fruits).filter(v -> v.length() > 4).collect(Collectors.toList());
        Set<String> set = Stream.of(fruits).filter(v -> v.length() > 4).collect(Collectors.toSet());
        TreeSet<String> treeSet = Stream.of(fruits).filter(v -> v.length() > 4).collect(Collectors.toCollection(TreeSet::new));
        String fruitsString = Stream.of(fruits).filter(v -> v.length() > 4).collect(Collectors.joining(","));
        System.out.println(fruitsString);

        IntSummaryStatistics sum = Stream.of(fruits).collect(Collectors.summarizingInt(String::length));
        System.out.println(sum.getMax());
        System.out.println(sum.getAverage());
        System.out.println(sum.getCount());

        List<Bill> bills = new CollectExploring().buildBillsArrayList();
        BillTotalCalculator calculator = bill -> bill.getSum().getAmount();
        DoubleSummaryStatistics statistics = bills.stream().map(calculator::calculate).map(BigDecimal::doubleValue)
                .collect(Collectors.summarizingDouble(amount -> amount));

        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());

        Map<Person, Bill> personBillMap = bills.stream().collect(Collectors.toMap(Bill::getPerson, Function.identity(),
                (exists, current) -> exists));
        System.out.println(personBillMap);

        Map<Person, List<Bill>> personListMap = bills.stream().collect(Collectors.groupingBy(Bill::getPerson));

        personListMap.forEach((key, value) -> System.out.println(key + "=" + value));
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
