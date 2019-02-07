package com.codurance.salaryslip;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;

public class SalarySlipGeneratorShould {
    @Test
    void calculate_gross_salary_per_month_for_an_employee() {
        Employee employee = new Employee("Bill B Bronson", 67890, BigDecimal.valueOf(3000));
        SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator();
        SalarySlip expectedSalarySlip  = new SalarySlip(employee, BigDecimal.valueOf(250));
        MatcherAssert.assertThat(expectedSalarySlip, is(salarySlipGenerator.generateFor(employee)));
    }
}
