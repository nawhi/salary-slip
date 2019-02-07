package com.codurance.salaryslip;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryCalculatorShould {

    @ParameterizedTest
    @CsvSource({
            "3000,250",
            "1500,125",
            "5000,416.67"
    })
    void calculate_gross_salary_per_month_for_an_employee(int annualSalary, double expectedMonthlySalary) {
        SalaryCalculator calculator = new SalaryCalculator(new Money(annualSalary));

        Money actualMonthlySalary = calculator.invoke();

        assertEquals(new Money(expectedMonthlySalary), actualMonthlySalary);
    }
}