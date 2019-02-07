package com.codurance.salaryslip;

import java.math.BigDecimal;

public class Employee {
    private final String name;
    private final int id;
    private final BigDecimal annualSalary;

    Employee(String name, int id, BigDecimal annualSalary) {
        this.name = name;
        this.id = id;
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", annualSalary=" + annualSalary +
                '}';
    }

    BigDecimal getAnnualSalary() {
        return annualSalary;
    }
}
