package Assignment4;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/11/2016.
 */
public class Hangman extends ConsoleProgram{

    private HangmanLexicon dictionary = new HangmanLexicon();
    private String word;
    private String guess;
    private String incorrectGuesses;
    private int guessCount;

    private HangmanCanvas canvas;


    public void init() {
        canvas = new HangmanCanvas();
        add(canvas);
    }
    public void run() {
        boolean preference = true;
        do {
            String response = readLine("Would you like to play Hangman? ");
            if(response.length() == 0) {

            } else if(Character.toLowerCase(response.charAt(0)) == 'y') {
                playHangman();
            }
        } while(preference);
    }

    private void playHangman() {
        canvas.reset();
        word = dictionary.getWord(rand.nextInt(dictionary.getWordCount()));
        guess = "";
        incorrectGuesses = "";
        for (int i = 0; i < word.length(); i++) {
            guess += "-";
        }
        canvas.displayWord(guess);
        guessCount = 0;
        while(guessCount < MAX_GUESSES) {
            char currentGuess = getGuess();
            implementGuess(currentGuess);
            if(guessIsCorrect()) {
                gameWon();
                break;
            }

        }
        if(!guessIsCorrect() && guessCount == 8) {
            gameLost();
        }

    }
    private void gameWon() {
        println("You guessed the word: " + guess);
        println("You win!");
        canvas.gameOver(true);
    }
    private void gameLost() {
        println("You lost. The word was " + word);
        canvas.gameOver(false);
        canvas.displayWord(word);
    }
    private void replaceChars(char ch) {
        for(int i = 0; i < word.length(); i++){
            if (word.charAt(i) == ch) guess = guess.substring(0, i) + ch + guess.substring(i + 1);
        }
    }
    private void implementGuess(char ch) {
        if(word.indexOf(ch) != -1) {
            println("That guess is correct.");
            replaceChars(ch);
            canvas.displayWord(guess);
        } else {
            println("There are no " + ch + "'s in the word.");
            incorrectGuesses += ch;
            canvas.noteIncorrectGuess(ch);
            guessCount++;
        }
    }
    private char getGuess() {
        println("The word now looks like this: " + guess);
        canvas.displayWord(guess);
        println("You have " + (MAX_GUESSES - guessCount) + " guesses left.");
        String str = readLine("Your guess: ");
        if(str.length() > 1) return illegalGuess();
        char temp = Character.toUpperCase(str.charAt(0));
        if(!Character.isAlphabetic(temp)) return nonalphabeticGuess();
        return temp;
    }
    private char illegalGuess() {
        println("You can only guess one letter at a time.");
        return getGuess();
    }
    private char nonalphabeticGuess() {
        println("You must guess a letter.");
        return getGuess();
    }
    private boolean guessIsCorrect() {
        return word.equals(guess);
    }
    private static final int MAX_GUESSES = 8;
    private RandomGenerator rand = RandomGenerator.getInstance();
}
