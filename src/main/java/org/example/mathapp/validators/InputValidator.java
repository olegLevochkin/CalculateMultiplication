package org.example.mathapp.validators;

import org.example.mathapp.exceptions.InvalidInputException;

import java.math.BigInteger;

public class InputValidator {

    public static void validateNumber(String input) throws InvalidInputException {
        if (!isValidNumber(input)) {
            throw new InvalidInputException("Invalid number: " + input);
        }
    }

    private static boolean isValidNumber(String input) {
        try {
            new BigInteger(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
