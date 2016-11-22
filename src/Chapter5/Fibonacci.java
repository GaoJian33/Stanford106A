package Chapter5;

import acm.program.ConsoleProgram;

/**
 * Section Handout #2
 * Problem 1
 */
public class Fibonacci extends ConsoleProgram{
    private static final int MAX_TERM_VALUE = 10000;

    public void run() {
        int first = 0;
        int second = 1;

        println("This program lists the Fibonacci sequence.");
        println(first);
        println(second);
        int next = first + second;
        while (next < MAX_TERM_VALUE) {
            println(next);
            first = second;
            second = next;
            next = first + second;
        }
    }
}
