package com.codurance.salaryslip;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

class SalarySlipGeneratorShould {

    @Test
    void calculate_gross_salary_per_month_for_an_employee() {
        Money annualSalary = new Money(3000);
        int id = 67890;
        String bill_b_bronson = "Bill B Bronson";
        Employee employee = new Employee(bill_b_bronson, id, annualSalary);
        SalarySlipGenerator salarySlipGenerator = new SalarySlipGenerator();

        Money expectedNiContribution = new Money(0);
        Money expectedMonthlyGrossSalary = new Money(250);
        SalarySlip expectedSalarySlip  = new SalarySlip(employee, expectedMonthlyGrossSalary, expectedNiContribution);

        MatcherAssert.assertThat(expectedSalarySlip, is(salarySlipGenerator.generateFor(employee)));
    }
}
