package com.codurance.salaryslip;

import junitparams.converters.Param;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;

class SalarySlipGeneratorShould {
    @ParameterizedTest
    @CsvSource({
            "3000,250",
            "1500,125",
            "5000,416.67"
    })
    void calculate_gross_salary_per_month_for_an_employee(int annualSalary, double expectedMonthlySalary) {
        Employee employee = new Employee("Bill B Bronson", 67890, BigDecimal.valueOf(annualSalary));
        SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator();
        SalarySlip expectedSalarySlip  = new SalarySlip(employee, BigDecimal.valueOf(expectedMonthlySalary));
        MatcherAssert.assertThat(expectedSalarySlip, is(salarySlipGenerator.generateFor(employee)));
    }
}
