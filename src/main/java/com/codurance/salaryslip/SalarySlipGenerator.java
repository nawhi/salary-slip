package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.SalaryCalculator;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();
        Money monthlyGrossSalary = new SalaryCalculator(annualSalary).calculateGrossMonthlySalary();
        Money weeklyLowerBoundThreshold = new Money(162);
        double lowerBandNIRate = 0.12;
        Money nationalInsuranceContribution = new SalaryCalculator(annualSalary).calculateNationalInsuranceContribution(weeklyLowerBoundThreshold, lowerBandNIRate);
        return new SalarySlip(employee, monthlyGrossSalary, nationalInsuranceContribution);
    }

}
