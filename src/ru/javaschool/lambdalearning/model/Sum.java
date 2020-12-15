package ru.javaschool.lambdalearning.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Sum {
    BigDecimal amount;

    public Sum(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Total{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sum sum = (Sum) o;
        return amount.equals(sum.amount) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
