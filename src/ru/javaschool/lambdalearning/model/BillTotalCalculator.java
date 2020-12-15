package ru.javaschool.lambdalearning.model;

import java.math.BigDecimal;

@FunctionalInterface
public interface BillTotalCalculator {
    BigDecimal calculate(Bill bill);
}
