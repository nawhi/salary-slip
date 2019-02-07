package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private BigDecimal value;

    Money(double value) {
        this(BigDecimal.valueOf(value));
    }

    Money(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.CEILING);
    }

    Money divide(double divisor) {
        return new Money(value.divide(BigDecimal.valueOf(divisor), RoundingMode.CEILING));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return money.value.compareTo(value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
