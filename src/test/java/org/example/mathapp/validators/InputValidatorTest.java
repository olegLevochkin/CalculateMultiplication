package org.example.mathapp.validators;

import org.example.mathapp.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    public void shouldValidatePositiveNumber() {
        assertDoesNotThrow(() -> InputValidator.validateNumber("1234567890"));
    }

    @Test
    public void shouldValidateNegativeNumber() {
        assertDoesNotThrow(() -> InputValidator.validateNumber("-987654321"));
    }

    @Test
    public void shouldValidateZero() {
        assertDoesNotThrow(() -> InputValidator.validateNumber("0"));
    }

    @Test
    public void shouldValidateLargeNumber() {
        assertDoesNotThrow(() -> InputValidator.validateNumber(new BigInteger("9999999999999999999999999999").toString()));
    }

    @Test
    public void shouldThrowExceptionForNonNumericInput() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNumber("abc123");
        });
        assertEquals("Invalid number: abc123", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionForSpecialCharacterInput() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNumber("@#%!");
        });
        assertEquals("Invalid number: @#%!", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionForEmptyString() {
        InvalidInputException exception = assertThrows(InvalidInputException.class, () -> {
            InputValidator.validateNumber("");
        });
        assertEquals("Invalid number: ", exception.getMessage());
    }

    @Test
    public void shouldThrowNullPointerExceptionForNullInput() {
        assertThrows(NullPointerException.class, () -> {
            InputValidator.validateNumber(null);
        });
    }
}