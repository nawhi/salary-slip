package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import com.codurance.salaryslip.calculators.GrossMonthlySalaryCalculator;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();
        GrossMonthlySalaryCalculator grossMonthlySalaryCalculator = new GrossMonthlySalaryCalculator(annualSalary);
        Money monthlyGrossSalary = grossMonthlySalaryCalculator.calculateGrossMonthlySalary();
        Money weeklyLowerBoundThreshold = new Money(162);
        double lowerBandNIRate = 0.12;
        Money nationalInsuranceContribution = NationalInsuranceCalculator.calculate(annualSalary, weeklyLowerBoundThreshold.multiply(52), lowerBandNIRate, GrossMonthlySalaryCalculator.UPPER_BOUND_THRESHOLD, GrossMonthlySalaryCalculator.UPPER_RATE);
        return new SalarySlip(employee, monthlyGrossSalary, nationalInsuranceContribution);
    }

}
