package com.codurance.salaryslip;

class NationalInsuranceCalculator {
    static Money calculate(Money salary, Money lowerBound, double rate) {
        if (salary.isGreaterThan(lowerBound))
            return salary.subtract(lowerBound).multiply(rate);
        return new Money(0);
    }
}
