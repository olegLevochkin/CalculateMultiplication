package org.example.mathapp.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InvalidInputException extends Exception {
    private final String message;
}
