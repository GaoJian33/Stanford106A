package Chapter3;

import acm.program.ConsoleProgram;

/**
 * File: InchesToCentimeters.java
 *
 * This program converts inches to centimeters.
 *
 * Chapter 3 Programming Assignment - extension to feet and inches
 *
 */
public class InchesToCentimeters extends ConsoleProgram {

    private static final double CENTIMETERS_PER_INCH = 2.54;

    public void run() {
        println("This program converts feet and inches to centimeters.");
        int feet = readInt("Enter number of feet: ");
        int inches = readInt("Enter number of inches: ");
        double cm = ((feet * 12) + inches) * CENTIMETERS_PER_INCH;
        println(feet + "ft " + inches + "in = " + cm + "cm");
    }
}
