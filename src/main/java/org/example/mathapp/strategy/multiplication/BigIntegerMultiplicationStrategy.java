package org.example.mathapp.strategy.multiplication;

import org.example.mathapp.strategy.MathOperationStrategy;

import java.math.BigInteger;

public class BigIntegerMultiplicationStrategy implements MathOperationStrategy {

    @Override
    public String calculate(String multiplicand, String multiplier) {
        BigInteger bigMultiplicand = new BigInteger(multiplicand);
        BigInteger bigMultiplier = new BigInteger(multiplier);

        return bigMultiplicand.multiply(bigMultiplier).toString();
    }
}
