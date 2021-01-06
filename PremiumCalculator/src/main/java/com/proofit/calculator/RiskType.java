package com.proofit.calculator;

import java.math.BigDecimal;

public enum RiskType {

    FIRE(0.014, 0.024, 100),
    THEFT(0.11, 0.05, 15);

    private final BigDecimal defaultCoefficient;
    private final BigDecimal modifiedCoefficient;
    private final BigDecimal boundary;

    RiskType(double defaultCoefficient, double modifiedCoefficient, double boundary) {
        this.defaultCoefficient = BigDecimal.valueOf(defaultCoefficient);
        this.modifiedCoefficient = BigDecimal.valueOf(modifiedCoefficient);
        this.boundary = BigDecimal.valueOf(boundary);
    }

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
