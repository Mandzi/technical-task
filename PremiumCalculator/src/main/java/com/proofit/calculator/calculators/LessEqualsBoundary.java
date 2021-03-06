package com.proofit.calculator.calculators;

import java.math.BigDecimal;

public class LessEqualsBoundary extends CostCalculator {

    public LessEqualsBoundary(BigDecimal defaultCoefficient, BigDecimal modifiedCoefficient, BigDecimal boundary) {
        super(defaultCoefficient, modifiedCoefficient, boundary);
    }

    @Override
    public BigDecimal calculate(BigDecimal insuredSum) {
        if (insuredSum == null || insuredSum.compareTo(BigDecimal.ZERO) < 1) {
            return BigDecimal.ZERO;
        }

        if (insuredSum.compareTo(getBoundary()) > 0 || insuredSum.compareTo(getBoundary()) == 0) {
            return insuredSum.multiply(getModifiedCoefficient());
        }
        return insuredSum.multiply(getDefaultCoefficient());
    }
}
