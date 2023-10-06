/*
 * EE422C Project 2 (Mastermind) submission by
 * Safin Rashid
 * srr3288
 * Slip days used: <0>
 * Spring 2023
 */
package assignment2;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Use this for your testing.  We will not be calling this method.

        boolean inTest = true;
        int numGuesses = 12;
        String[] colors = new String[]{"R","O","Y","G","B","P"};
        int numPegs = 4;

        GameConfiguration entry = new GameConfiguration(numGuesses, colors, numPegs);
        start(inTest, entry, new SecretCodeGenerator(entry));
    }

    public static void start(Boolean isTesting, GameConfiguration config, SecretCodeGenerator generator) {
        //TODO: complete this method. We will call this method from our JUnit test cases.

        System.out.println("Welcome to Mastermind.");
        Scanner input = new Scanner(System.in);
        Game Mastermind = new Game(isTesting, config, generator, input);

        while(true) {
            System.out.println("Do you want to play a new game? (Y/N):");
            String select = input.nextLine();
            if (select.equals("Y"))
                Mastermind.runGame();
            else if (select.equals("N"))
                break;
            //else System.out.println("INVALID_SELECTION"); System.out.println(); //used for test

        }
    }
}
