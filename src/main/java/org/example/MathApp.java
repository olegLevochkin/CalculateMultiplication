package org.example;

import org.example.mathapp.MathAppRunner;
import org.example.mathapp.exceptions.InvalidInputException;

public class MathApp {
    public static void main(String[] args) {
        MathAppRunner runner = new MathAppRunner();
        try {
            runner.run(args);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}