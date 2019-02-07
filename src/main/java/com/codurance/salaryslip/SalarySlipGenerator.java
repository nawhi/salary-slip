package com.codurance.salaryslip;

import java.math.BigDecimal;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        Money annualSalary = employee.getAnnualSalary();
        return new SalarySlip(employee, new Money(755.00), new SalaryCalculator(annualSalary).invoke());
    }

}
