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

    Money calculateNationalInsuranceContribution() {
        Money lowerBandThresholdPerWeek = new Money(162.01);
        Money lowerBandThresholdAnnual = lowerBandThresholdPerWeek.multiply(WEEKS_IN_A_YEAR);
        if(annualSalary.subtract(lowerBandThresholdAnnual).isPositive()) {
            double lowerBandNIRate = 0.12;
            return annualSalary.subtract(lowerBandThresholdAnnual).multiply(lowerBandNIRate);
        }
        return new Money(0);
    }
}
