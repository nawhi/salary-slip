package com.codurance.salaryslip;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static java.math.RoundingMode.CEILING;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryCalculatorShould {

    @ParameterizedTest
    @CsvSource({
            "3000,250",
            "1500,125",
            "5000,416.67"
    })
    void calculate_gross_salary_per_month_for_an_employee(int annualSalary, double expectedMonthlySalary) {
        SalaryCalculator calculator = new SalaryCalculator(BigDecimal.valueOf(annualSalary));

        BigDecimal actualMonthlySalary = calculator.invoke();

        assertBigDecimalsEqual(BigDecimal.valueOf(expectedMonthlySalary), actualMonthlySalary);
    }

    private void assertBigDecimalsEqual(BigDecimal a, BigDecimal b) {
        BigDecimal scaledB = b.setScale(2, CEILING);
        BigDecimal scaledA = a.setScale(2, CEILING);
        assertEquals(0, scaledA.compareTo(scaledB));
    }

}