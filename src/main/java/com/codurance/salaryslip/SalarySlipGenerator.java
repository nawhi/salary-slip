package com.codurance.salaryslip;

import java.math.BigDecimal;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        BigDecimal annualSalary = employee.getAnnualSalary();
        return new SalarySlip(employee, new SalaryCalculator(annualSalary).invoke());
    }

}
