package Chapter2;

import acm.program.ConsoleProgram;
/*
 * This program computes the area of triangle by asking the user for base and height.
 *
 * From:
 * The Art and Science of Java
 * Chapter 2
 * Programming Exercise 2
 */
public class AreaOfTriangle extends ConsoleProgram {
    public void run() {
        double base = readDouble("Enter base: ");
        double height = readDouble("Enter height: ");
        double area = (base * height) / 2;
        println("Area = " + area);
    }
}
