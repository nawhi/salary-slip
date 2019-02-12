package com.codurance.salaryslip;

class NationalInsuranceCalculator {
    static Money calculate(Money salary, Money lowerBound, double lowerRate, Money upperBound, double upperRate) {
        if (salary.isGreaterThan(upperBound))
            return upperBound.subtract(lowerBound).multiply(lowerRate).add((salary).subtract(upperBound).multiply(upperRate));
        if (salary.isGreaterThan(lowerBound))
            return salary.subtract(lowerBound).multiply(lowerRate);
        return new Money(0);
    }
}
