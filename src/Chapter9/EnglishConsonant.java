package Chapter9;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/11/2016.
 */
public class EnglishConsonant extends ConsoleProgram {
    private static final int MIN_LETTERS = 3;
    private static final int MAX_LETTERS = 8;

    public void run() {
        println("This program will tell you if a letter is a consonant.");
        String str = readLine("Enter a letter: ");
        char ch = str.charAt(0);
        println(isEnglishConsonant(ch) ? "This letter is a consonant." : "This letter is not a consonant.");
        StringBuilder sb = new StringBuilder();
        for(char i = 'A'; i <= 'Z'; i++) {
            if(isEnglishConsonant(i)) sb.append(i);
        }
        println(sb.toString());
        println("");
        println("");
        for (int i = 0; i < 5; i++) {
            String word = randomWord();
            println(word + " is worth " + scrabbleScore(word) + " Scrabble points.");
        }
        String word = readLine("Enter a word, in all caps: ");
        println(word + " is worth " + scrabbleScore(word) + " Scrabble points.");

        while(true) {
            String digits = readLine("Enter a numeric string: ");
            if (digits.length() == 0) break;
            println(addCommasToNumericString(digits));
        }

        ghost(13);
    }

    private String addCommasToNumericString(String digits) {
        String response = "";
        for (int i = 1; i <= digits.length(); i++) {
            response = (digits.charAt(digits.length() - i)) + response;
            if(i % 3 == 0 && i < digits.length()) response = "," + response;
        }
        return response;
    }

    private int scrabbleScore(String word) {
        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            switch(word.charAt(i)) {
                case'Q':case'Z':
                    score += 2;
                case'J':case'X':
                    score += 3;
                case'K':
                    score++;
                case 'F':case 'H':case 'V':case 'W':case 'Y':
                    score++;
                case 'B':case 'C':case 'M':case 'P':
                    score++;
                case 'D':case'G':
                    score++;
                case 'A':case 'E':case 'I':case 'L':case 'N':case 'S':case 'R':case 'T':case 'U':case 'O':
                    score++;
                    break;
                default:
            }
        }
        return score;
    }
    private boolean isEnglishConsonant(char ch) {
        if(!Character.isAlphabetic(ch)) return false;
        switch (Character.toLowerCase(ch)) {
            case 'a':case 'e':case 'i':case 'o':case 'u':
                return false;
            default:
                return true;
        }
    }

    private String randomWord() {
        int length = rand.nextInt(MIN_LETTERS, MAX_LETTERS);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<length; i++) {
            int t = rand.nextInt('A', 'Z');
            sb.append(Character.toChars(t));
        }
        return sb.toString();
    }

    private void ghost(int x) {
        int y = 0;
        for (int i = 1; i < x; i *= 2) {
            y = witch(y, skeleton(x, i));
        }
        println("ghost: x = " + x + ", y = " + y);
    }
    private int witch(int x, int y) {
        x = 10 * x + y;
        println("witch: x = " + x + ", y = " + y);
        return x;
    }
    private int skeleton(int x, int y) {
        return x / y % 2;
    }



    RandomGenerator rand = RandomGenerator.getInstance();
}
