package com.codurance.salaryslip;

class SalaryCalculator {
    private Money annualSalary;

    SalaryCalculator(Money annualSalary) {
        this.annualSalary = annualSalary;
    }

    Money invoke() {
        return annualSalary.divide(12);
    }
}
