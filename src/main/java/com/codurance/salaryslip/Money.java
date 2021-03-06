package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Money {
    private BigDecimal moneyValue;

    public Money(double moneyValue) {
        this(BigDecimal.valueOf(moneyValue));
    }

    public Money(BigDecimal moneyValue) {
        this.moneyValue = moneyValue.setScale(2, RoundingMode.HALF_UP);
    }

    public Money divide(double divisor) {
        return new Money(moneyValue.divide(BigDecimal.valueOf(divisor), RoundingMode.HALF_UP));
    }

    public Money subtract(Money value) {
        return new Money(moneyValue.subtract(value.moneyValue));
    }

    public Money multiply(double value) {
        return new Money(moneyValue.multiply(BigDecimal.valueOf(value)));
    }

    public boolean isPositive() {
        return this.moneyValue.compareTo(BigDecimal.ZERO) > 0;
    }

    public boolean isGreaterThan(Money other) {
        return moneyValue.compareTo(other.moneyValue) > 0;
    }

    public Money add(Money value) {
        return new Money(moneyValue.add(value.moneyValue));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return money.moneyValue.setScale(2, RoundingMode.HALF_UP)
                    .compareTo(moneyValue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moneyValue);
    }

    @Override
    public String toString() {
        return "Money{" +
                "moneyValue=" + moneyValue +
                '}';
    }
}
