package com.codurance.salaryslip;

class SalaryCalculator {
    private Money annualSalary;

    SalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    Money calculateGrossMonthlySalary() {
        return annualSalary.divide(12);
    }

    public Money calculateNationalInsuranceContribution() {
        if(annualSalary.subtract(8424).isPositive())
            return annualSalary.subtract(8424).multiply(0.12);
        return new Money(0);
    }
}
