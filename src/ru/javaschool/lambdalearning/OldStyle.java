package ru.javaschool.lambdalearning;

import java.util.Comparator;

public class OldStyle {
    public static void main(String[] args) { ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
    }
}
