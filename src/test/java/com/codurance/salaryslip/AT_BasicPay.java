package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AT_BasicPay {

    @Test
    void generate_monthly_slip_for_basic_pay() {
        Employee employee = new Employee("John J Doe", 12345, BigDecimal.valueOf(5000));
        SalarySlipGenerator generator = new SalarySlipGenerator();
        SalarySlip expectedSlip = new SalarySlip(employee, BigDecimal.valueOf(416.67));

        SalarySlip generatedSlip = generator.generateFor(employee);

        assertEquals(expectedSlip, generatedSlip);
    }
}
