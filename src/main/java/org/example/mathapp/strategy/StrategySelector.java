package org.example.mathapp.strategy;

import org.example.mathapp.context.MathContext;
import org.example.mathapp.exceptions.InvalidInputException;
import org.example.mathapp.strategy.multiplication.BigIntegerMultiplicationStrategy;
import org.example.mathapp.strategy.multiplication.ManualMultiplicationStrategy;

public class StrategySelector {

    public static MathContext selectStrategy(String algorithm) throws InvalidInputException {
        switch (algorithm) {
            case "--alg1":
                return new MathContext(new BigIntegerMultiplicationStrategy());
            case "--alg2":
                return new MathContext(new ManualMultiplicationStrategy());
            default:
                throw new InvalidInputException("Unknown operation selected.");
        }
    }
}
