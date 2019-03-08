package com.codurance.salaryslip;

import com.codurance.salaryslip.calculators.NationalInsuranceCalculator;
import com.codurance.salaryslip.calculators.GrossMonthlySalaryCalculator;

class SalarySlipGenerator {

    private final NationalInsuranceRepository nationalInsuranceRepository = new NationalInsuranceRepository();

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();

        Money monthlyGrossSalary = new GrossMonthlySalaryCalculator(annualSalary).calculateGrossMonthlySalary();

        NationalInsuranceCalculator calculator = new NationalInsuranceCalculator(
                nationalInsuranceRepository.getLowerBoundThreshold(),
                nationalInsuranceRepository.getLowerRate(),
                nationalInsuranceRepository.getUpperBoundThreshold(),
                nationalInsuranceRepository.getUpperRate());

        Money contribution = calculator.calculate(annualSalary);
        return new SalarySlip(employee, monthlyGrossSalary, contribution);
    }

}
