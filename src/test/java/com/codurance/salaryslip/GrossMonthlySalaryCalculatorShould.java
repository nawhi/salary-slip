package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import com.codurance.salaryslip.calculators.GrossMonthlySalaryCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GrossMonthlySalaryCalculatorShould {

    @ParameterizedTest
    @MethodSource("grossSalaryData")
    void calculate_gross_salary_per_month_for_an_employee(Money annualSalary, Money expectedMonthlySalary) {
        GrossMonthlySalaryCalculator calculator = new GrossMonthlySalaryCalculator(annualSalary);

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
}