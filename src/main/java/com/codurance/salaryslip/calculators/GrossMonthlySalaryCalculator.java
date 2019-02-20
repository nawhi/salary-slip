package com.codurance.salaryslip.calculators;

import com.codurance.salaryslip.Money;

public class GrossMonthlySalaryCalculator {
    private static final int WEEKS_IN_A_YEAR = 52;
    public final Money annualSalary;
    public static final Money UPPER_BOUND_THRESHOLD = new Money(892).multiply(52);
    public static final double UPPER_RATE = 0.02;

    public GrossMonthlySalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Money calculateGrossMonthlySalary() {
        return annualSalary.divide(12);
    }
}
