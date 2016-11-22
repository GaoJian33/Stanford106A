package Chapter3;

import acm.program.ConsoleProgram;

import static java.lang.Math.PI;

/**
 * File: InterestCalculator.java
 * This program calculates new balance after one year of interest
 * Chapter 3 Programming Exercise 2 & 3
 */
public class InterestCalculator extends ConsoleProgram {

    public void run() {
        println("Interest calculation program");
        double balance = readDouble("Enter starting balance: ");
        double intRate = readDouble("Enter annual interest rate: ");
        balance += (balance * intRate / 100);
        println("Balance after one year = " + balance);
        balance += (balance * intRate / 100);
        println("Balance after two years = " + balance);
        println("");
        double radius = readDouble("Enter the radius of a circle: ");
        double area = PI * radius * radius;
        println("The area of the circle is " + area);
    }
}
