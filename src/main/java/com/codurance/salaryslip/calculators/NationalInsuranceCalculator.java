package com.codurance.salaryslip.calculators;

import com.codurance.salaryslip.Money;

public class NationalInsuranceCalculator {
    public static Money calculate(Money salary, Money lowerBound, double lowerRate, Money upperBound, double upperRate) {
        if (isAboveNIBoundary(salary, upperBound)){
            return calculateBoundaryContributions(upperBound, lowerBound,lowerRate)
                    .add(calculateBoundaryContributions(salary, upperBound, upperRate));
        }
        if (isAboveNIBoundary(salary, lowerBound)) {
            return calculateBoundaryContributions(salary, lowerBound, lowerRate);
        }
        return new Money(0);
    }

    private static Money calculateBoundaryContributions(Money salary, Money lowerBound, double lowerRate) {
        return salary.subtract(lowerBound).multiply(lowerRate);
    }

    private static boolean isAboveNIBoundary(Money salary, Money upperBound) {
        return salary.isGreaterThan(upperBound);
    }
}
