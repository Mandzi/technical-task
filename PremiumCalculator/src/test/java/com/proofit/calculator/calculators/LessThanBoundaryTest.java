package com.proofit.calculator.calculators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LessThanBoundaryTest {

    private static CostCalculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new LessThanBoundary(BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.75), BigDecimal.valueOf(100));
    }

    @ParameterizedTest(name = "{index}: Expecting result \"{1}\", when insured sum is \"{0}\"")
    @MethodSource("arguments")
    void shouldReturnCorrectValue_basedOnInputs(BigDecimal insuredSum, BigDecimal expectedResult) {
        // Act
        var result = calculator.calculate(insuredSum);
        // Assert
        assertEquals(expectedResult.setScale(2, RoundingMode.HALF_UP), result.setScale(2, RoundingMode.HALF_UP), "Result does not match expected result");
    }

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(5), BigDecimal.valueOf(2.5)),
                Arguments.of(BigDecimal.valueOf(100), BigDecimal.valueOf(50)),
                Arguments.of(BigDecimal.valueOf(1000), BigDecimal.valueOf(750)),
                Arguments.of(BigDecimal.ZERO, BigDecimal.ZERO),
                Arguments.of(null, BigDecimal.ZERO),
                Arguments.of(BigDecimal.valueOf(-1), BigDecimal.ZERO)
        );
    }
}