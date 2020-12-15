package ru.javaschool.lambdalearning;

public class OldStyleStreamExploring {
    public static void main(String[] args) {
        String[] fruit = new String[] {"apple", "banana", "lime", "strawberry"};

        int count = 0;
        for (String f: fruit) {
            if (f.length() > 4) count++;
        }

        System.out.println(count);
    }
}
