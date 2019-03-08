package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NationalInsuranceCalculatorShould {

    @Test
    void return_zero_for_incomes_under_the_minimum_threshold() {
        NationalInsuranceCalculator nationalInsuranceCalculator = new NationalInsuranceCalculator(
                new Money(6000), 0.1,
                new Money(7000), 0.01
        );
        Money contribution = nationalInsuranceCalculator.calculate(new Money(5000));
        assertEquals(new Money(0), contribution);
    }

    @ParameterizedTest
    @MethodSource("lowerRateContribData")
    void return_lower_rate_contribution_for_salary_above_lower_bound(Money salary, Money lowerBound, double rate, Money expectedContribution) {
        NationalInsuranceCalculator nationalInsuranceCalculator = new NationalInsuranceCalculator(
                lowerBound,
                rate,
                new Money(10000),
                0.01
        );
        Money contribution = nationalInsuranceCalculator.calculate(salary);
        assertEquals(expectedContribution, contribution);
    }

    private static Stream<Arguments> lowerRateContribData() {
        return Stream.of(
                Arguments.of(new Money(3000), new Money(2000), 0.1, new Money(100)),
                Arguments.of(new Money(6000), new Money(2000), 0.2, new Money(800)),
                Arguments.of(new Money(100.01), new Money(100), 0.1, new Money(0)),
                Arguments.of(new Money(100.01), new Money(100), 0.5, new Money(0.01))


        );
    }

    @Test
    void return_upper_rate_contribution_for_salary_above_upper_bound() {
        Money salary = new Money(10000);
        Money lowerBound = new Money(5000);
        double lowerRate = 0.1;
        Money upperBound = new Money(9000);
        double upperRate = 0.01;
        NationalInsuranceCalculator nationalInsuranceCalculator = new NationalInsuranceCalculator(
                lowerBound,
                lowerRate,
                upperBound,
                upperRate
        );
        Money contributionTemp = nationalInsuranceCalculator.calculate(salary);
        double contributeCalculated = 4000 *0.1 + 1000 * 0.01;
        assertEquals(new Money(contributeCalculated), contributionTemp);
    }
}
