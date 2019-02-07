package com.codurance.salaryslip;

import java.util.Objects;

public class SalarySlip {
    private final Employee employee;
    private final Money monthlyGrossSalary;
    private final Money nationalInsuranceContribution;

    SalarySlip(Employee employee, Money monthlyGrossSalary, Money nationalInsuranceContribution) {
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
                monthlyGrossSalary.equals(that.monthlyGrossSalary) &&
                nationalInsuranceContribution.equals(that.nationalInsuranceContribution);
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
