package Assignment2;

import acm.program.ConsoleProgram;

/**
 * Created by Michael on 11/3/2016.
 */
public class Hailstone extends ConsoleProgram {
    public void run() {
        int counter = 0;
        int number = readInt("Enter a number: ");
        do {
            if (number % 2 == 1) {
                println(number + " is odd, so I make 3n + 1: " + ((3 * number) + 1));
                number = (3 * number) + 1;
            } else {
                println(number + " is even, so I take half: " + number / 2);
                number /= 2;
            }
            counter++;
        } while (number != 1);
        println(counter + " steps");
    }
}
