package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.util.Objects;

public class SalarySlip {
    private final Employee employee;
    private final BigDecimal monthlyGrossSalary;

    SalarySlip(Employee employee, BigDecimal monthlyGrossSalary) {
        this.employee = employee;
        this.monthlyGrossSalary = monthlyGrossSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalarySlip that = (SalarySlip) o;
        return Objects.equals(employee, that.employee) && (monthlyGrossSalary.compareTo(that.monthlyGrossSalary) == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, monthlyGrossSalary);
    }

    @Override
    public String toString() {
        return "SalarySlip{" +
                "employee=" + employee +
                ", monthlyGrossSalary=" + monthlyGrossSalary +
                '}';
    }
}
