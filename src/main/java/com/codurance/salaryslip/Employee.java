package com.codurance.salaryslip;

public class Employee {
    private final String name;
    private final int id;
    private final Money annualSalary;

    Employee(String name, int id, Money annualSalary) {
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

    Money getAnnualSalary() {
        return annualSalary;
    }
}
