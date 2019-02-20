package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.SalaryCalculator;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();
        SalaryCalculator salaryCalculator = new SalaryCalculator(annualSalary);
        Money monthlyGrossSalary = salaryCalculator.calculateGrossMonthlySalary();
        Money weeklyLowerBoundThreshold = new Money(162);
        double lowerBandNIRate = 0.12;
        Money nationalInsuranceContribution = salaryCalculator.calculateNationalInsuranceContribution(lowerBandNIRate, weeklyLowerBoundThreshold.multiply(52));
        return new SalarySlip(employee, monthlyGrossSalary, nationalInsuranceContribution);
    }

}
