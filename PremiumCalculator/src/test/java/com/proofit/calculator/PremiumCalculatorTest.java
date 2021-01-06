package com.proofit.calculator;

import com.proofit.calculator.objects.Policy;
import com.proofit.calculator.objects.PolicyObject;
import com.proofit.calculator.objects.PolicySubObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PremiumCalculatorTest {

    @Test
    void shouldReturnCorrectPremium_whenPassedInAPolicy() {
        // Assign
        var object = new PolicyObject("House", List.of(
                new PolicySubObject("Item1", BigDecimal.valueOf(100), RiskType.FIRE),
                new PolicySubObject("Item2", BigDecimal.valueOf(8), RiskType.THEFT)
        ));
        var policy = new Policy();
        policy.setObjects(Collections.singletonList(object));

        // Act & Assert
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        assertEquals(BigDecimal.valueOf(2.28), premiumCalculator.calculate(policy));
    }

    @Test
    void shouldReturnCorrectPremium_whenPassedInAPolicy2() {
        // Assign
        var object = new PolicyObject("House", List.of(
                new PolicySubObject("Item1", BigDecimal.valueOf(500), RiskType.FIRE),
                new PolicySubObject("Item2", BigDecimal.valueOf(102.51), RiskType.THEFT)
        ));
        var policy = new Policy();
        policy.setObjects(Collections.singletonList(object));

        // Act & Assert
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        assertEquals(BigDecimal.valueOf(17.13), premiumCalculator.calculate(policy));
    }

    @Test
    void shouldReturnCorrectPremium_whenPassedInAPolicyWith5Items() {
        // Assign
        var object = new PolicyObject("House", List.of(
                new PolicySubObject("Item1", BigDecimal.valueOf(500), RiskType.FIRE),
                new PolicySubObject("Item2", BigDecimal.valueOf(12), RiskType.FIRE),
                new PolicySubObject("Item3", BigDecimal.valueOf(102.51), RiskType.THEFT),
                new PolicySubObject("Item4", BigDecimal.valueOf(1020.51), RiskType.THEFT),
                new PolicySubObject("Item5", BigDecimal.valueOf(1.51), RiskType.THEFT)
        ));
        var policy = new Policy();
        policy.setObjects(Collections.singletonList(object));

        // Act & Assert
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        assertEquals(BigDecimal.valueOf(68.51), premiumCalculator.calculate(policy));
    }

    @Test
    void shouldReturnZero_whenPassedInAPolicyWithNoItems() {
        // Assign
        var object = new PolicyObject("House", Collections.emptyList());
        var policy = new Policy();
        policy.setObjects(Collections.singletonList(object));

        // Act & Assert
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP), premiumCalculator.calculate(policy));
    }

    @Test
    void shouldReturnZero_whenPassedInANull() {
        // Act & Assert
        PremiumCalculator premiumCalculator = new PremiumCalculator();
        assertEquals(BigDecimal.ZERO, premiumCalculator.calculate(null));
    }
}