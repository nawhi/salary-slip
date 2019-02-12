package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NationalInsuranceCalculatorShould {

    @Test
    void return_zero_for_incomes_under_the_minimum_threshold() {
        Money contribution = NationalInsuranceCalculator.calculate(
                new Money(5000), // ANNUAL salary
                new Money(6000)  // ANNUAL contribution lower bound
        );
        assertEquals(new Money(0), contribution);
    }
}
