package org.example.mathapp.context;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.mathapp.strategy.MathOperationStrategy;

@Getter
@Setter
@RequiredArgsConstructor
public class MathContext {
    private final MathOperationStrategy strategy;

    public String executeStrategy(String num1, String num2) {
        return strategy.calculate(num1, num2);
    }
}
