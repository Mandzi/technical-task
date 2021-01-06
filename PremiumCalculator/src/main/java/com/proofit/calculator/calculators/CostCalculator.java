package com.proofit.calculator.calculators;

import java.math.BigDecimal;

public abstract class CostCalculator {

    private final BigDecimal defaultCoefficient;
    private final BigDecimal modifiedCoefficient;
    private final BigDecimal boundary;

    public CostCalculator(BigDecimal defaultCoefficient, BigDecimal modifiedCoefficient, BigDecimal boundary) {
        this.defaultCoefficient = defaultCoefficient;
        this.modifiedCoefficient = modifiedCoefficient;
        this.boundary = boundary;
    }

    public abstract BigDecimal calculate(BigDecimal insuredSum);

    public BigDecimal getDefaultCoefficient() {
        return defaultCoefficient;
    }

    public BigDecimal getModifiedCoefficient() {
        return modifiedCoefficient;
    }

    public BigDecimal getBoundary() {
        return boundary;
    }
}
