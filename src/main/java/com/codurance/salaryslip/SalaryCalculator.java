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
        return calculateNationalInsuranceContribution(new Money(162.01), 0.12);
    }

    Money calculateNationalInsuranceContribution(Money lowerBandThresholdPerWeek, double lowerBandNIRate) {
        Money lowerBandThresholdAnnual = lowerBandThresholdPerWeek.multiply(WEEKS_IN_A_YEAR);
        if(annualSalary.subtract(lowerBandThresholdAnnual).isPositive()) {
            return annualSalary.subtract(lowerBandThresholdAnnual).multiply(lowerBandNIRate);
        }
        return new Money(0);
    }
}
