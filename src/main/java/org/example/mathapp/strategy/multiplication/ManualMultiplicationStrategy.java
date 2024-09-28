package org.example.mathapp.strategy.multiplication;

import org.example.mathapp.strategy.MathOperationStrategy;

public class ManualMultiplicationStrategy implements MathOperationStrategy {

    @Override
    public String calculate(String multiplicand, String multiplier) {
        boolean isNegative = (multiplicand.startsWith("-") && !multiplier.startsWith("-")) ||
                (!multiplicand.startsWith("-") && multiplier.startsWith("-"));

        multiplicand = multiplicand.replace("-", "");
        multiplier = multiplier.replace("-", "");

        int multiplicandLength = multiplicand.length();
        int multiplierLength = multiplier.length();

        int[] result = new int[multiplicandLength + multiplierLength];

        for (int i = multiplierLength - 1; i >= 0; i--) {
            int multiplierDigit = charToDigit(multiplier.charAt(i));
            for (int j = multiplicandLength - 1; j >= 0; j--) {
                int multiplicandDigit = charToDigit(multiplicand.charAt(j));
                int multiplication = multiplicandDigit * multiplierDigit;

                int positionLow = i + j + 1;
                int positionHigh = i + j;

                int sum = multiplication + result[positionLow];

                result[positionLow] = sum % 10;
                result[positionHigh] += sum / 10;
            }
        }

        String finalResult = convertResultDigitsToString(result);

        return isNegative && !"0".equals(finalResult) ? "-" + finalResult : finalResult;
    }

    private int charToDigit(char c) {
        return c - '0';
    }

    private String convertResultDigitsToString(int[] digits) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int digit : digits) {
            if (!(resultBuilder.length() == 0 && digit == 0)) {
                resultBuilder.append(digit);
            }
        }

        return resultBuilder.length() == 0 ? "0" : resultBuilder.toString();
    }
}