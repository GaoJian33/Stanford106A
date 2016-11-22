package Section5;

import acm.program.ConsoleProgram;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Michael on 11/13/2016.
 */
public class WordCount extends ConsoleProgram {
     public void run() {
         int lines = 0;
         int words = 0;
         int chars = 0;
         try {
             String file = readLine("Enter File name: ");
             Scanner rd = new Scanner(new File(file));
             while (true) {
                 String line = rd.nextLine();
                 if(line == null) break;
                 lines++;
                 StringTokenizer st = new StringTokenizer(line);
                 while(true) {
                     String word = st.nextToken();
                     if(word == null) break;
                     words++;
                     for (int i = 0; i < word.length(); i++) {
                         chars++;
                     }
                 }
             }
         } catch (java.io.IOException e) {
             e.printStackTrace();
         }
         println("Lines = " + lines);
         println("Words = " + words);
         println("Chars = " + chars);
     }
}
