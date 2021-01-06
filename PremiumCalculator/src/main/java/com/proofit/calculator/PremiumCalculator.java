package com.proofit.calculator;

import com.proofit.calculator.calculators.CalculatorFactory;
import com.proofit.calculator.objects.Policy;
import com.proofit.calculator.objects.PolicyObject;
import com.proofit.calculator.objects.PolicySubObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PremiumCalculator {

    public BigDecimal calculate(Policy policy) {
        if (policy == null) {
            return BigDecimal.ZERO;
        }

        var groupedSums = new HashMap<RiskType, BigDecimal>();

        policy.getObjects().stream()
                .map(PolicyObject::getSubObjects)
                .flatMap(List::stream)
                .forEach(item -> addToGroups(groupedSums, item));

        var cost = BigDecimal.ZERO;
        for (Map.Entry<RiskType, BigDecimal> entry : groupedSums.entrySet()) {
            cost = cost.add(CalculatorFactory.getCalculator(entry.getKey()).calculate(entry.getValue()));
        }
        return cost.setScale(2, RoundingMode.HALF_UP);
    }

    private void addToGroups(HashMap<RiskType, BigDecimal> group, PolicySubObject policySubObject) {
        group.merge(policySubObject.getRisk(), policySubObject.getInsuredSum(), BigDecimal::add);
    }
}
