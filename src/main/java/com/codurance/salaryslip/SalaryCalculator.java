package com.codurance.salaryslip;

class SalaryCalculator {
    private static final int WEEKS_IN_A_YEAR = 52;
    private Money annualSalary;

    SalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    Money calculateGrossMonthlySalary() {
        return annualSalary.divide(12);
    }

    Money calculateNationalInsuranceContribution(Money lowerBandThresholdPerWeek, double lowerBandNIRate) {
        Money weeklyUpperBoundThreshold = new Money(892);
        double upperRate = 0.02;
        return NationalInsuranceCalculator.calculate(this.annualSalary, lowerBandThresholdPerWeek.multiply(52), lowerBandNIRate, weeklyUpperBoundThreshold.multiply(52), upperRate);
    }
}
