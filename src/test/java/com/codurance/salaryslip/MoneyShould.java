package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
