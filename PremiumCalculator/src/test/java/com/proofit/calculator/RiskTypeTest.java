package com.proofit.calculator;

import com.proofit.calculator.calculators.CalculatorFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RiskTypeTest {

    @ParameterizedTest(name = "{index}: Expecting result \"{2}\", when risk type is \"{0}\" and insured sum is \"{1}\"")
    @MethodSource("arguments")
    void shouldCallNotifyServiceOnSaveAlert(RiskType riskType, double insuredSum, double expectedResult) {
        // Assign
        var expected = BigDecimal.valueOf(expectedResult).setScale(2, RoundingMode.HALF_UP);
        var result = CalculatorFactory.getCalculator(riskType).calculate(BigDecimal.valueOf(insuredSum)).setScale(2, RoundingMode.HALF_UP);
        // Act & Assert
        assertEquals(expected, result, "Expected result doesn't match calculated sum");
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(RiskType.FIRE, 1, 0.01),
                Arguments.of(RiskType.FIRE, 100, 1.40),
                Arguments.of(RiskType.FIRE, 1000, 24),
                Arguments.of(RiskType.THEFT, 1, 0.11),
                Arguments.of(RiskType.THEFT, 15, 0.75),
                Arguments.of(RiskType.THEFT, 100, 5)
        );
    }
}