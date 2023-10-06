package assignment2;

import java.util.Scanner;

public class Game {
    private boolean isTesting;
    private GameConfiguration config;
    private SecretCodeGenerator generator;
    Scanner input;

    public Game(boolean isTesting, GameConfiguration config, SecretCodeGenerator generator, Scanner input){
        this.isTesting = isTesting;
        this.config = config;
        this.generator = generator;
        this.input = input;
    }

    //check to see if guess is case-sensitive and contains valid chars
    private static boolean validity(String[] valid, String code, String check, int n){

        if(check.length() != code.length()) return false; //different sizes

        for(int i = 0; i < n; i++){
            if(! Character.isUpperCase(check.charAt(i))) return false; //case sensitivity
            boolean validChar = false;
            for(int j = 0; j < valid.length; j++){  //invalid char/color
                if(valid[j].charAt(0) == check.charAt(i)) {
                    validChar = true;
                    break;
                }
            }
            if(! validChar) return false;
        }
        return true;
    }

    //when valid guess, respond with black/white results
    private static String giveResponse(String guess, String code){

        int black = 0, white  = 0;

        //convert to arrays to manipulate chars
        char[] guessArr = guess.toCharArray();
        char[] codeArr = code.toCharArray();

        //calculate black pegs
        for (int i = 0; i < guessArr.length; i++) {
            if (guessArr[i] == code.charAt(i)) {
                black++;
                guessArr[i] = codeArr[i] = '-'; //mark as counted
            }
        }

        //calculate white pegs
        for(int i = 0; i < guessArr.length; i++){
            for (int j = 0; j < codeArr.length; j++) {
                if (guessArr[i] == codeArr[j] &&
                        guessArr[i] != '-' && codeArr[j] != '-') {
                    white++;
                    guessArr[i] = codeArr[j] = '-';
                }
            }
        }

        return guess + " -> " + black + "b_" + white + "w";
    }

    public void runGame(){

        String code = generator.getNewSecretCode();
        //code = "BGOP"; //manual test case
        if (isTesting) System.out.println("Secret code: " + code); //test print

        int numGuesses = config.guessNumber; //reset guesses each game
        String[] history = new String[numGuesses]; //new history each game

        while (numGuesses > 0) {

            System.out.println();
            System.out.println("You have " + numGuesses + " guess(es) left.");
            System.out.println("Enter guess:");

            //Scanner inGuess = new Scanner(System.in); //input guess
            String guess = input.nextLine();

            //history command
            if (guess.equals("HISTORY")) {
                //print each past guess
                for (int i = 0; history[i] != null; i++) {
                    System.out.println(history[i]);
                }

                //invalid guess
            } else if (!validity(config.colors, code, guess, code.length())) {
                System.out.println("INVALID_GUESS");

                //guessed correctly
            } else if (guess.equals(code)) {
                System.out.println(guess + " -> 4b_0w");
                System.out.println("You win!");
                break;

                //valid but incorrect
            } else {
                String feedback = giveResponse(guess, code);
                history[config.guessNumber - numGuesses] = feedback; //store for history
                System.out.println(feedback);
                numGuesses--; //only remove guess when valid/incorrect
            }
            //when all guesses used
            if(numGuesses == 0){
                System.out.println("You lose! The pattern was " + code);
                System.out.println();
            }
        }

    }
}
