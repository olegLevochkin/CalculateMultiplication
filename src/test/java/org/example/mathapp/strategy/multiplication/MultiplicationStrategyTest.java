package org.example.mathapp.strategy.multiplication;

import org.example.mathapp.strategy.MathOperationStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultiplicationStrategyTest {

    private static Stream<MathOperationStrategy> provideStrategies() {
        return Stream.of(new BigIntegerMultiplicationStrategy(), new ManualMultiplicationStrategy());
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldMultiplySmallNumbers(MathOperationStrategy strategy) {
        String result = strategy.calculate("2", "3");
        assertEquals("6", result);
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldMultiplyLargeNumbers(MathOperationStrategy strategy) {
        String result = strategy.calculate("999999999999", "888888888888");
        String expected = "888888888887111111111112";
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldMultiplyNegativeNumbers(MathOperationStrategy strategy) {
        String result = strategy.calculate("-2", "3");
        assertEquals("-6", result);
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldMultiplyTwoNegativeNumbers(MathOperationStrategy strategy) {
        String result = strategy.calculate("-4", "-5");
        assertEquals("20", result);
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldReturnZeroWhenMultiplyingByZero(MathOperationStrategy strategy) {
        String result = strategy.calculate("0", "123456");
        assertEquals("0", result);
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldPerformLargeNumberMultiplicationWithinTimeLimit(MathOperationStrategy strategy) {
        String largeNumber1 = "12345678901234567890";
        String largeNumber2 = "11111111111111111111";

        long startTime = System.nanoTime();

        String result = strategy.calculate(largeNumber1, largeNumber2);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        String expected = "137174210013717420998628257899862825790";

        assertEquals(expected, result);
        assertTrue(duration < 2_000_000_000L, "Operation took too long: " + duration + " ns");
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    public void shouldPerformRepeatedSmallMultiplicationsEfficiently(MathOperationStrategy strategy) {
        int repetitions = 1_000_000;
        String multiplicand = "1234";
        String multiplier = "5678";
        String expected = "7006652";

        long startTime = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            String result = strategy.calculate(multiplicand, multiplier);
            assertEquals(expected, result);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        assertTrue(duration < 5_000_000_000L, "Operation took too long: " + duration + " ns for " + repetitions + " repetitions");
    }
}