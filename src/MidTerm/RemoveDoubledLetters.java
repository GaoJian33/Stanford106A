package MidTerm;

import acm.program.ConsoleProgram;

/**
 * Created by Michael on 11/12/2016.
 */
public class RemoveDoubledLetters extends ConsoleProgram {

    public void run() {
        String word = "";
        while(!word.equals("end")) {
            word = readLine("Enter a word: ");
            println(removeDoubledLetters(word));
        }
    }

    private String removeDoubledLetters(String word) {
        String newWord = "";
        newWord += word.charAt(0);
        for(int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch != word.charAt(i-1)) {
                newWord += ch;
            }
        }
        return newWord;
    }
}
