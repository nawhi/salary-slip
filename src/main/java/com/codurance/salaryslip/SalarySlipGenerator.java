package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import com.codurance.salaryslip.calculators.GrossMonthlySalaryCalculator;

class SalarySlipGenerator {

    private static final Money UPPER_BOUND_THRESHOLD = new Money(892).multiply(52);
    private static final double UPPER_RATE = 0.02;
    private static final Money LOWER_BOUND_THRESHOLD = new Money(162 * 52);
    private static final double LOWER_RATE = 0.12;

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();

        Money monthlyGrossSalary = new GrossMonthlySalaryCalculator(annualSalary).calculateGrossMonthlySalary();

        NationalInsuranceCalculator calculator = new NationalInsuranceCalculator(
                LOWER_BOUND_THRESHOLD,
                LOWER_RATE,
                UPPER_BOUND_THRESHOLD,
                UPPER_RATE);

        Money contribution = calculator.calculate(annualSalary);
        return new SalarySlip(employee, monthlyGrossSalary, contribution);
    }

}
