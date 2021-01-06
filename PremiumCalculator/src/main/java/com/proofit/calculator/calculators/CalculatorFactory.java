package com.proofit.calculator.calculators;

import com.proofit.calculator.RiskType;

public class CalculatorFactory {

    public static CostCalculator getCalculator(RiskType riskType) {
        switch (riskType) {
            case FIRE  : return new LessThanBoundary(riskType.getDefaultCoefficient(), riskType.getModifiedCoefficient(), riskType.getBoundary());
            case THEFT : return new LessEqualsBoundary(riskType.getDefaultCoefficient(), riskType.getModifiedCoefficient(), riskType.getBoundary());
            default    : throw new RuntimeException("Risk type not yet implemented");
        }
    }
}
