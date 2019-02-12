package com.codurance.salaryslip;

class NationalInsuranceCalculator {
    static Money calculate(Money salary, Money lowerBound, double rate) {
        if (salary.isGreaterThan(lowerBound))
            return new Money(100);
        return new Money(0);
    }
}
