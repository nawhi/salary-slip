package com.codurance.salaryslip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AT_BasicPay {

    @Test
    void generate_monthly_slip_for_basic_pay() {
        Money annualSalary = new Money(5000);
        int id = 12345;
        String john_j_doe = "John J Doe";
        Employee employee = new Employee(john_j_doe, id, annualSalary);
        SalarySlipGenerator generator = new SalarySlipGenerator();

        Money expectedMonthlySalary = new Money(416.67);
        Money expectedNationalInsuranceContributions = new Money(0);
        SalarySlip expectedSlip = new SalarySlip(employee, expectedMonthlySalary, expectedNationalInsuranceContributions);

        SalarySlip generatedSlip = generator.generateFor(employee);

        assertEquals(expectedSlip, generatedSlip);
    }
}
