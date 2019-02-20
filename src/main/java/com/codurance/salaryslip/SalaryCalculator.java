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
        return NationalInsuranceCalculator.calculate(this.annualSalary, lowerBandThresholdPerWeek.multiply(52), lowerBandNIRate, new Money(892).multiply(52), 0.02);
    }
}
