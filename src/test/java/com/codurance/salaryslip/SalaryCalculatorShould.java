package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.SalaryCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryCalculatorShould {

    @ParameterizedTest
    @MethodSource("grossSalaryData")
    void calculate_gross_salary_per_month_for_an_employee(Money annualSalary, Money expectedMonthlySalary) {
        SalaryCalculator calculator = new SalaryCalculator(annualSalary);

        Money actualMonthlySalary = calculator.calculateGrossMonthlySalary();

        assertEquals(expectedMonthlySalary, actualMonthlySalary);
    }

    private static Stream<Arguments> grossSalaryData() {
        return Stream.of(
                Arguments.of(new Money(3000),new Money(250)),
                Arguments.of(new Money(1500),new Money(125)),
                Arguments.of(new Money(5000),new Money(416.67))
        );
    }
    @ParameterizedTest
    @MethodSource("niContributionData")
    void calculate_national_insurance_contributions_per_month_for_a_annual_salary(Money annualSalary, Money expectedNationalInsuranceContribution) {
        SalaryCalculator calculator = new SalaryCalculator(annualSalary);

        final Money lowerBandThresholdPerWeek = new Money(162.01);
        Money actualNationalInsuranceContribution = calculator.calculateNationalInsuranceContribution(0.12, lowerBandThresholdPerWeek.multiply(52));

        assertEquals(expectedNationalInsuranceContribution, actualNationalInsuranceContribution);
    }

    private static Stream<Arguments> niContributionData() {
        return Stream.of(
                Arguments.of(new Money(8424),new Money(0)),
                Arguments.of(new Money(20424),new Money(1439.94))
        );
    }
}