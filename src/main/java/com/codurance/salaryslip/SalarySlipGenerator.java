package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import com.codurance.salaryslip.calculators.GrossMonthlySalaryCalculator;

class SalarySlipGenerator {

    public static final Money UPPER_BOUND_THRESHOLD = new Money(892).multiply(52);
    public static final double UPPER_RATE = 0.02;

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();

        Money monthlyGrossSalary = new GrossMonthlySalaryCalculator(annualSalary).calculateGrossMonthlySalary();

        Money weeklyLowerBoundThreshold = new Money(162);
        double lowerBandNIRate = 0.12;

        NationalInsuranceCalculator calculator = new NationalInsuranceCalculator(
                weeklyLowerBoundThreshold.multiply(52),
                lowerBandNIRate,
                UPPER_BOUND_THRESHOLD,
                UPPER_RATE);

        Money contribution = calculator.calculationFunction(annualSalary);
        return new SalarySlip(employee, monthlyGrossSalary, contribution);
    }

}
