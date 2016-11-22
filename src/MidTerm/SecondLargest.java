package MidTerm;

import acm.program.ConsoleProgram;

/**
 * Created by Michael on 11/3/2016.
 */
public class SecondLargest extends ConsoleProgram {
    private static final int SENTINAL = 0;
    public void run() {
        println("This program finds the largest and smallest numbers.");

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        while(true) {
            int current = readInt("? ");
            if (current == SENTINAL) break;
            if(current >= largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest) {
                secondLargest = current;
            }
        }
        if (largest == Integer.MIN_VALUE || secondLargest == Integer.MIN_VALUE) {
            println("You must enter at least values other than " + SENTINAL
                    + " if you want this program to actually do anything.");
        } else {
            println("The largest value is " + largest);
            println("The second largest is " + secondLargest);
        }
    }
}
