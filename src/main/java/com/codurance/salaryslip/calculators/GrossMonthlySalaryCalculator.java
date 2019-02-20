package com.codurance.salaryslip.calculators;

import com.codurance.salaryslip.Money;

public class GrossMonthlySalaryCalculator {
    private final Money annualSalary;

    public GrossMonthlySalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Money calculateGrossMonthlySalary() {
        return annualSalary.divide(12);
    }
}
