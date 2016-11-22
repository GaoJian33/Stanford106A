package Assignment2;

import acm.program.ConsoleProgram;

/**
 * Created by Michael on 11/3/2016.
 */
public class FindRange extends ConsoleProgram {
    private static final int SENTINAL = 0;
    public void run() {
        println("This program finds the largest and smallest numbers.");
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        while(true) {
            int current = readInt("? ");
            if (current == SENTINAL) break;
            smallest = (current < smallest) ? current : smallest;
            largest = (current > largest) ? current : largest;
        }
        if (smallest == Integer.MAX_VALUE && largest == Integer.MIN_VALUE) {
            println("You must enter some values other that " + SENTINAL
                + " if you want this program to actually do anything.");
        } else {
            println("smallest: " + smallest);
            println("largest: " + largest);
        }
    }
}
