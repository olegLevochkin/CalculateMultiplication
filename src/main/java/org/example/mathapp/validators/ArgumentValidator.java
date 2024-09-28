package org.example.mathapp.validators;

import org.example.mathapp.exceptions.InvalidInputException;

public class ArgumentValidator {

    public static void validate(String[] args) throws InvalidInputException {
        if (args == null || args.length < 3) {
            throw new InvalidInputException("Usage: <program> --alg1/--alg2/ <num1> <num2>");
        }
    }
}
