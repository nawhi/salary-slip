package com.codurance.salaryslip.calculators;

import com.codurance.salaryslip.Money;

public class SalaryCalculator {
    private static final int WEEKS_IN_A_YEAR = 52;
    private Money annualSalary;

    public SalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Money calculateGrossMonthlySalary() {
        return annualSalary.divide(12);
    }

    public Money calculateNationalInsuranceContribution(double lowerRate, Money lowerBoundThreshold) {
        double upperRate = 0.02;
        Money upperBoundThreshold = new Money(892).multiply(52);
        return NationalInsuranceCalculator.calculate(this.annualSalary, lowerBoundThreshold, lowerRate, upperBoundThreshold, upperRate);
    }
}
