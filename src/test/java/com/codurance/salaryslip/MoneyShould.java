package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoneyShould {

    @Test
    void compare_two_money_amounts_as_equal() {
        Money m1 = new Money(1);
        Money m2 = new Money(1.0);

        assertEquals(m1, m2);
    }

    @ParameterizedTest
    @CsvSource({
            "6,3,2",
            "2,3,0.67",
            "0.5,2,0.25"
    })
    void can_be_divided_by_a_number(BigDecimal start, double divisor, BigDecimal result) {
        assertEquals(new Money(result), new Money(start).divide(divisor));
    }

    @ParameterizedTest
    @CsvSource({
            "6,3,18",
    })
    void can_be_multiplied_by_a_number(BigDecimal start, double multiplicand, BigDecimal result) {
        assertEquals(new Money(result), new Money(start).multiply(multiplicand));
    }

    @ParameterizedTest
    @CsvSource({
            "6,3,3",
    })
    void can_be_subtracted_by_a_number(BigDecimal start, double subtrahend, BigDecimal result) {
        assertEquals(new Money(result), new Money(start).subtract(new Money(subtrahend)));
    }

    @ParameterizedTest
    @CsvSource({
            "6,true",
    })
    void can_be_subtracted_by_a_number(double testValue, boolean result) {
        assertEquals(result, new Money(testValue).isPositive());
    }

    @ParameterizedTest
    @CsvSource({
            "2,1,true",
            "1,2,false",
            "1,1,false"
    })
    void can_be_greater_than_another_Money(int lvalue, int rvalue, boolean expectedResult) {
        assertEquals(expectedResult, new Money(lvalue).isGreaterThan(new Money(rvalue)));
    }

}
