package com.codurance.salaryslip;

import java.math.BigDecimal;
import java.util.Objects;

public class SalarySlip {
    private final Employee employee;
    private final BigDecimal monthlyGrossSalary;
    private final BigDecimal nationalInsuranceContribution;

    SalarySlip(Employee employee, BigDecimal monthlyGrossSalary) {
        this.employee = employee;
        this.monthlyGrossSalary = monthlyGrossSalary;
        this.nationalInsuranceContribution = BigDecimal.valueOf(0);
    }

    public SalarySlip(Employee employee, BigDecimal monthlyGrossSalary, BigDecimal nationalInsuranceContribution) {
        this.employee = employee;
        this.monthlyGrossSalary = monthlyGrossSalary;
        this.nationalInsuranceContribution = nationalInsuranceContribution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalarySlip that = (SalarySlip) o;
        return Objects.equals(employee, that.employee) &&
                (monthlyGrossSalary.compareTo(that.monthlyGrossSalary) == 0) &&
                (nationalInsuranceContribution.compareTo(that.nationalInsuranceContribution) == 0);
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
                ", nationalInsuranceContribution=" + nationalInsuranceContribution +
                '}';
    }
}
