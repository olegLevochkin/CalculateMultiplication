package org.example.mathapp.validators;

import org.example.mathapp.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentValidatorTest {

    @Test
    public void shouldValidateWhenArgumentsAreValid() {
        String[] validArgs = {"--alg1", "123", "456"};
        assertDoesNotThrow(() -> ArgumentValidator.validate(validArgs));
    }

    @Test
    public void shouldThrowExceptionWhenArgumentsAreNull() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            ArgumentValidator.validate(null);
        });
        assertEquals("Usage: <program> --alg1/--alg2/ <num1> <num2>", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenArgumentsAreLessThanThree() {
        String[] invalidArgs = {"--alg1", "123"};
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            ArgumentValidator.validate(invalidArgs);
        });
        assertEquals("Usage: <program> --alg1/--alg2/ <num1> <num2>", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenArgumentsAreEmpty() {
        String[] emptyArgs = {};
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            ArgumentValidator.validate(emptyArgs);
        });
        assertEquals("Usage: <program> --alg1/--alg2/ <num1> <num2>", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenOneArgumentIsProvided() {
        String[] oneArg = {"--alg1"};
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            ArgumentValidator.validate(oneArg);
        });
        assertEquals("Usage: <program> --alg1/--alg2/ <num1> <num2>", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenTwoArgumentsAreProvided() {
        String[] twoArgs = {"--alg1", "123"};
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            ArgumentValidator.validate(twoArgs);
        });
        assertEquals("Usage: <program> --alg1/--alg2/ <num1> <num2>", exception.getMessage());
    }
}
