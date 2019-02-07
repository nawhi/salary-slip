package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AT_BasicPay {

    @Test
    void generate_monthly_slip_for_basic_pay() {
        Employee employee = new Employee("John J Doe", 12345, new Money(5000));
        SalarySlipGenerator generator = new SalarySlipGenerator();
        SalarySlip expectedSlip = new SalarySlip(employee, new Money(755.00), new Money(416.67));

        SalarySlip generatedSlip = generator.generateFor(employee);

        assertEquals(expectedSlip, generatedSlip);
    }
}
