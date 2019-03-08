package com.codurance.salaryslip;

class NationalInsuranceRepository {
    private static final Money UPPER_BOUND_THRESHOLD = new Money(892 * 52);
    private static final double UPPER_RATE = 0.02;
    private static final Money LOWER_BOUND_THRESHOLD = new Money(162 * 52);
    private static final double LOWER_RATE = 0.12;

    double getUpperRate() {
        return UPPER_RATE;
    }

    Money getUpperBoundThreshold() {
        return UPPER_BOUND_THRESHOLD;
    }

    double getLowerRate() {
        return LOWER_RATE;
    }

    Money getLowerBoundThreshold() {
        return LOWER_BOUND_THRESHOLD;
    }
}