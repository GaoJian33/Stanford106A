package Assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Michael on 11/11/2016.
 */
public class HangmanLexicon {

    private ArrayList<String> lexicon;

    public HangmanLexicon() {
        lexicon = new ArrayList<>();
        BufferedReader s;
        // read file
        try {
            s = new BufferedReader(new FileReader("C:\\Users\\Michael\\IntelliJProjects\\Stanford106A\\data\\ShorterLexicon.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        // add words to lexicon
        while(true) {
            String str = null;
            try {
                str = s.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (str == null) {
                break;
            }
            lexicon.add(str);
        }
    }
    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return lexicon.size();
    }

    /** Returns the word at the specified index. */
    public String getWord(int index) {
        return lexicon.get(index);
    }
}
