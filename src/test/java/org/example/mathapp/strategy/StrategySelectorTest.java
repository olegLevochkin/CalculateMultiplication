package org.example.mathapp.strategy;

import org.example.mathapp.context.MathContext;
import org.example.mathapp.exceptions.InvalidInputException;
import org.example.mathapp.strategy.multiplication.BigIntegerMultiplicationStrategy;
import org.example.mathapp.strategy.multiplication.ManualMultiplicationStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StrategySelectorTest {

    @Test
    public void shouldSelectBigIntegerMultiplicationStrategyForAlg1() throws InvalidInputException {
        MathContext context = StrategySelector.selectStrategy("--alg1");

        assertTrue(context.getStrategy() instanceof BigIntegerMultiplicationStrategy);
    }

    @Test
    public void shouldSelectManualMultiplicationStrategyForAlg2() throws InvalidInputException {
        MathContext context = StrategySelector.selectStrategy("--alg2");

        assertTrue(context.getStrategy() instanceof ManualMultiplicationStrategy);
    }

    @Test
    public void shouldThrowExceptionForUnknownAlgorithm() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            StrategySelector.selectStrategy("--unknown");
        });

        assertEquals("Unknown operation selected.", exception.getMessage());
    }
}