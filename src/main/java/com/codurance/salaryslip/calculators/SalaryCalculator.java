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

    public Money calculateNationalInsuranceContribution(Money lowerBandThresholdPerWeek, double lowerBandNIRate) {
        Money weeklyUpperBoundThreshold = new Money(892);
        double upperRate = 0.02;
        return NationalInsuranceCalculator.calculate(this.annualSalary, lowerBandThresholdPerWeek.multiply(52), lowerBandNIRate, weeklyUpperBoundThreshold.multiply(52), upperRate);
    }
}
