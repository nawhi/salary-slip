package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.math.RoundingMode;

class SalaryCalculator {
    private BigDecimal annualSalary;

    SalaryCalculator(BigDecimal annualSalary) {
        this.annualSalary = annualSalary;
    }

    BigDecimal invoke() {
        return annualSalary.divide(BigDecimal.valueOf(12), 2, RoundingMode.CEILING);
    }
}
