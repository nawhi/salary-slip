package com.codurance.salaryslip;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AT_NationalInsuranceContribution {
    @Disabled
    @Test
    void generate_monthly_slip_for_basic_pay_with_national_insurance_contributions() {
        Employee employee = new Employee("John J Doe", 12345, new Money(9060.00));
        SalarySlipGenerator generator = new SalarySlipGenerator();
        SalarySlip generatedSlip = generator.generateFor(employee);
        SalarySlip expectedSlip = new SalarySlip(employee, new Money(755.00), new Money(10));

        assertEquals(expectedSlip, generatedSlip);
    }
}
