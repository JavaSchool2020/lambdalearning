package ru.javaschool.lambdalearning.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Bill {
    Person person;
    Sum sum;

    public Bill(String name, BigDecimal amount) {
        this.person = new Person(name);
        this.sum = new Sum(amount);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Sum getSum() {
        return sum;
    }

    public void setSum(Sum sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "person=" + person +
                ", sum=" + sum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(person, bill.person) &&
                Objects.equals(sum, bill.sum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, sum);
    }
}
