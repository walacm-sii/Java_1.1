package org.example;

import java.util.Random;
import java.util.Scanner;

public class Guesser {

    private final int numberToGuess;
    private int counter;
    private final Scanner scanner;

    public Guesser() {
        numberToGuess = new Random().nextInt(100);
        counter = 5;
        scanner = new Scanner(System.in);
    }

    public void startGuessing() {
        System.out.println("Guess the integer number from range 0-99.");
        while (counter != 0) {
            int userNumber = scanner.nextInt();
            counter -= 1;
            if (checkIfGuessCorrect(userNumber)) {
                return;
            } else if (counter != 0) {
                System.out.printf("You have %d more tries\n", counter);
                System.out.println("Please try again");
            }
        }
        System.out.printf("Sorry you didn't guess the number, the answer was: %d", numberToGuess);
    }

    private boolean checkIfGuessCorrect(int number) {
        if (number == numberToGuess) {
            System.out.println("You guessed it!");
            return true;
        } else if (number > numberToGuess && counter != 0) {
            System.out.println("Your number is GREATER than the one you are trying to guess");

        } else if (number < numberToGuess && counter != 0) {
            System.out.println("Your number is LOWER than the one you are trying to guess");
        }
        return false;
    }
}
