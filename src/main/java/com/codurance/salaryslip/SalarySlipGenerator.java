package com.codurance.salaryslip;

import java.math.BigDecimal;

public class SalarySlipGenerator {

    public SalarySlip generateFor(Employee employee) {
        return new SalarySlip(employee, BigDecimal.valueOf(250));
    }
}
