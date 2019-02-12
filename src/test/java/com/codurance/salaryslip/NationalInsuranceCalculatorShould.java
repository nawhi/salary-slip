package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NationalInsuranceCalculatorShould {

    @Test
    void return_zero_for_incomes_under_the_minimum_threshold() {
        Money contribution = NationalInsuranceCalculator.calculate(
                new Money(5000),
                new Money(6000),
                0.1);
        assertEquals(new Money(0), contribution);
    }

    @ParameterizedTest
    @MethodSource("lowerRateContribData")
    void return_lower_rate_contribution_for_salary_above_lower_bound(Money salary, Money lowerBound, double rate, Money expectedContribution) {
        Money contribution = NationalInsuranceCalculator.calculate(
                salary,
                lowerBound,
                rate
        );
        assertEquals(expectedContribution, contribution);
    }

    static Stream<Arguments> lowerRateContribData() {
        return Stream.of(
                Arguments.of(new Money(3000), new Money(2000), 0.1, new Money(100))
        );
    }
}
