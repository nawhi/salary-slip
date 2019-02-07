package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.math.RoundingMode;

class SalarySlipGenerator {

    SalarySlip generateFor(Employee employee) {
        BigDecimal annualSalary = employee.getAnnualSalary();
        return new SalarySlip(employee, getMonthlySalary(annualSalary));
    }

    private BigDecimal getMonthlySalary(BigDecimal annualSalary) {
        return annualSalary.divide(BigDecimal.valueOf(12), RoundingMode.UNNECESSARY);
    }
}
