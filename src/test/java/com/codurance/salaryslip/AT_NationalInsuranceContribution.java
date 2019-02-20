package com.codurance.salaryslip;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AT_NationalInsuranceContribution {
    @Test
    void generate_monthly_slip_for_basic_pay_with_national_insurance_contributions() {
        Money annualSalary = new Money(8476.00);
        int id = 12345;
        String john_j_doe = "John J Doe";
        Employee employee = new Employee(john_j_doe, id, annualSalary);
        SalarySlipGenerator generator = new SalarySlipGenerator();
        SalarySlip generatedSlip = generator.generateFor(employee);

        Money expectedNiContributions = new Money(6.24);
        Money expectedMonthlyGrossSalary = new Money(706.33);
        SalarySlip expectedSlip = new SalarySlip(employee, expectedMonthlyGrossSalary, expectedNiContributions);

        assertEquals(expectedSlip, generatedSlip);
    }
}
