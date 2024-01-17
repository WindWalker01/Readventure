/*
 * 
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private Scanner scanner;

    private  App appState;

    private int wordBankSelector;
    private String hint = "";
    private String hiddenWord;
    private int attempts = 0; // how many attempts did the user got

    private int correctGuesses = 0;

    private boolean didWin = false;

    String[] asciiString = {
            "  +---+\r\n" + //
                    "  |   |\r\n" + //
                    "      |\r\n" + //
                    "      |\r\n" + //
                    "      |\r\n" + //
                    "      |\r\n" + //
                    "=========" +
                    "",
            "  +---+\n" + //
                    "  |   |\n" + //
                    "  O   |\n" + //
                    "      |\n" + //
                    "      |\n" + //
                    "      |\n" + //
                    "=========\n" + //
                    "",
            "  +---+\n" + //
                    "  |   |\n" + //
                    "  O   |\n" + //
                    "  |   |\n" + //
                    "      |\n" + //
                    "      |\n" + //
                    "=========\n" + //
                    "",
            "  +---+\r\n" + //
                    "  |   |\r\n" + //
                    "  O   |\r\n" + //
                    " /|   |\r\n" + //
                    "      |\r\n" + //
                    "      |\r\n" + //
                    "=========" +
                    "",
            "  +---+\n" + //
                    "  |   |\n" + //
                    "  O   |\n" + //
                    " /|\\  |\n" + //
                    "      |\n" + //
                    "      |\n" + //
                    "=========\n" + //
                    "",
            "  +---+\n" + //
                    "  |   |\n" + //
                    "  O   |\n" + //
                    " /|\\  |\n" + //
                    " /    |\n" + //
                    "      |\n" + //
                    "=========\n" + //
                    "",
            "  +---+\n" + //
                    "  |   |\n" + //
                    "  O   |\n" + //
                    " /|\\  |\n" + //
                    " / \\  |\n" + //
                    "      |\n" + //
                    "=========\n" + //
                    ""

    };
    String[] wordBankAnimal = { "Dog", "Cat", "Pig", "Snake", "Mouse", "Spider", "Elephant", "Giraffe", "Goat", "Lion",
            "Chicken", "Fish", "Bird", "Horse", "Cow"
    };

    String[] wordBankVehicle = { "car", "Train", "Bus", "Tricycle", "Bicycle", "Van", "Boat", "Truck", "Crane",
            "Tractor", "Helicopter", "Airplane", "Motorcycle", "Jeep", "Taxi"

    };

    String[] wordBankFood = { "Candy", "Chocolate", "Noodles", "Salad", "Steak", "Tuna", "Shrimp", "Burger", "Rice",
            "Hot-dog", "Spaghetti", "Pizza", "Bread", "Eggs", "Cake"
    };

    ArrayList<Character> usedLetters = new ArrayList<>();

    public Hangman(Scanner _scanner, Random _random, App _app) {
        scanner = _scanner;
        appState = _app;

        // randomised int for selecting what kind/type of word to choose
        wordBankSelector = _random.nextInt(3);


        // This gets the randomised Word in the specific word bank array variables and
        // determines the hint for the user.

        if (wordBankSelector == 0) {
            hint = "The word is an animal";
            hiddenWord = wordBankAnimal[_random.nextInt(wordBankAnimal.length - 1)];
        } else if (wordBankSelector == 1) {
            hint = "The word is a vehicle";
            hiddenWord = wordBankVehicle[_random.nextInt(wordBankVehicle.length - 1)];
        } else if (wordBankSelector == 2) {
            hint = "The word is a food";
            hiddenWord = wordBankFood[_random.nextInt(wordBankFood.length - 1)];
        }

    }

    public void Play() {
        System.out.println(hiddenWord);
        System.out.println("Guess the word before the prisoner get hung!");


        // If the user is not out of attempts then continue the loop
        while (attempts < 6) {
            //Reset the number of correct guesses
            correctGuesses = 0;
            System.out.println(asciiString[attempts]);// Prints the state of the hanged man using an array.

            // Prints the all the correct guesses that the user
            // inputted into the correct order
            for (int i = 0; i < hiddenWord.length(); i++) {

                // if the letter is already guessed by the user then reveal the letter
                // if not then print an underscore
                if (usedLetters.contains(hiddenWord.charAt(i))) {
                    System.out.print(" " + hiddenWord.charAt(i) + " ");
                } else {
                    System.out.print(" _ ");
                }

            }

            System.out.print("\n\nletters used: ");

            // Display all the user's used letters to the prompt
            // We firstly check if the usedLetter[] array is not empty before displaying it.
            if (!usedLetters.isEmpty()) {
                for (char letters : usedLetters) {
                    System.out.print(letters + " ");
                }
            }

            // Giving the user hints if the number of guesses is greater than three.
            if (attempts > 3) {
                System.out.println("\n\nhint: " + hint);
            }

            System.out.print("\nPick A letter: ");
            char response = scanner.next().charAt(0); // get the user response

            // Makes the user's response and the hidden word all lowercase so that
            // no matter what casing the user inputted, it will always be the same and
            // consistent.
            response = Character.toLowerCase(response);
            hiddenWord = hiddenWord.toLowerCase();


            // Check if the user's response is in the List of characters in the hidden word
            // else if the response is wrong then add 1 to the attempt
            if (hiddenWord.contains(response + "")) {

                //If the user's response is already in the usedLetter array
                // then we are going to skip to the next iteration
                if(usedLetters.contains(response)){

                    //Tell to the user that the current response this iteration is already been inputted.
                    System.err.println("\nThat letter is already answered.\n");
                    continue;
                }

                System.out.println("\nCorrect!");


            } else {
                System.out.println("\nWrong!");
                attempts++;
            }

            // Add the user's response to an array.
            usedLetters.add(response);

            //Checks how many correct guessed we got
            for (int i = 0; i < hiddenWord.length(); i++) {

                // get the number of correct guesses relative to the number
                // of letters in the hidden word.
                // if the index of usedLetter[] contains the character in the hiddenWord
                // then we add the correctGuesses variable to 1.
                // This will loop through all the hiddenWord's character
                // Meaning if there is a duplicate character in the hidden word it will count as two points
                //! This is important because we are checking if the user wins by comparing the
                // length of the hidden word to the correct guesses.
                if (usedLetters.contains(hiddenWord.charAt(i))) {
                    correctGuesses++;
                }

            }

            // Determine if the number of correct guesses is the same
            // as the length of the hidden word string
            // if it is then the user won, and we break out of this while loop.
           if(correctGuesses == hiddenWord.length()){
               didWin = true;
                break;
           }

        }

        // This checks if we did not guess the hidden word
        if (!didWin) {
            System.out.println(asciiString[6]);
            System.out.println("The prisoner got hanged!");
        } else {
            // If the number of correct guesses is the same as the number of characters in
            // the hidden word then that means the user successfully guessed the hidden
            // word.
            System.out.println("Congratulations! You guessed the word: " + hiddenWord + "!");
        }


        // then we set the didWin variable to false so that when the user wants to play again
        // it will not automatically win instantaneously.
        didWin = false;

        // We ask if the user wants to try again or go back to the menu screen.
        System.out.println("\n\nWant to try again?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("\nEnter the number: ");
        int input = scanner.nextInt();



        if (input == 1) {
            attempts = 0;
            appState.currentState = AppState.Hangman;
        } else if (input == 2) {
            appState.currentState = AppState.Menu;
        } else {
            System.out.println("Invalid! Going back to the menu...");
            appState.currentState = AppState.Menu;
        }

    }

}