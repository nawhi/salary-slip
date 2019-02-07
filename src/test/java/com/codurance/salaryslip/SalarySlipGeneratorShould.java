package com.codurance.salaryslip;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

class SalarySlipGeneratorShould {

    @Test
    void calculate_gross_salary_per_month_for_an_employee() {
        Employee employee = new Employee("Bill B Bronson", 67890, new Money(3000));
        SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator();

        SalarySlip expectedSalarySlip  = new SalarySlip(employee, new Money(755.00), new Money(250));

        MatcherAssert.assertThat(expectedSalarySlip, is(salarySlipGenerator.generateFor(employee)));
    }
}
