package com.codurance.salaryslip;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();
        Money monthlyGrossSalary = new SalaryCalculator(annualSalary).calculateGrossMonthlySalary();
        Money nationalInsuranceContribution = new SalaryCalculator(annualSalary).calculateNationalInsuranceContribution(new Money(162).multiply(52), 0.12);
        return new SalarySlip(employee, monthlyGrossSalary, nationalInsuranceContribution);
    }

}
