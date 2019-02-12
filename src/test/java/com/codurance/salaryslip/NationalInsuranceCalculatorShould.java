package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NationalInsuranceCalculatorShould {

    @Test
    void return_zero_for_incomes_under_the_minimum_threshold() {
        Money contribution = NationalInsuranceCalculator.calculate(
                new Money(5000), // ANNUAL salary
                new Money(6000),  // ANNUAL contribution lower bound
                0.1);
        assertEquals(new Money(0), contribution);
    }

    @Test
    void return_lower_rate_contribution_for_salary_above_lower_bound() {
        Money contribution = NationalInsuranceCalculator.calculate(
                new Money(3000), // salary
                new Money(2000), // lower bound
                0.1 // lower rate
        );
        assertEquals(new Money(100), contribution);
    }
}
