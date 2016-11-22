package Chapter2;

import acm.program.*;

/**
 * Created by Michael on 11/1/2016.
 *
 * Includes:
 * Art and Science of Java
 * Chapter 2
 * Programming Exercise 3
 */
public class Add2Integers extends ConsoleProgram {

    public void run() {
        println("This program adds three integers.");
        int n1 = readInt("Enter n1: ");
        int n2 = readInt("Enter n2: ");
        int n3 = readInt("Enter n3: ");
        int total = n1 + n2 + n3;
        println("The total is " + total + ".");
    }
}
