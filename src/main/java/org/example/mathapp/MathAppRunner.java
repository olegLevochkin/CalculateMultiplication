package org.example.mathapp;

import org.example.mathapp.context.MathContext;
import org.example.mathapp.exceptions.InvalidInputException;
import org.example.mathapp.strategy.StrategySelector;
import org.example.mathapp.validators.ArgumentValidator;
import org.example.mathapp.validators.InputValidator;

public class MathAppRunner {

    public void run(String[] args) throws InvalidInputException {
        ArgumentValidator.validate(args);

        String algorithm = args[0];
        String num1 = args[1];
        String num2 = args[2];

        InputValidator.validateNumber(num1);
        InputValidator.validateNumber(num2);

        MathContext context = StrategySelector.selectStrategy(algorithm);
        String result = context.executeStrategy(num1, num2);

        System.out.println("Result: " + result);
    }
}