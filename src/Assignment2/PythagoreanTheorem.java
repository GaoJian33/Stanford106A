package Assignment2;

import acm.program.ConsoleProgram;

import static javax.swing.UIManager.getInt;

/**
 * Created by Michael on 11/3/2016.
 */
public class PythagoreanTheorem extends ConsoleProgram {
    public void run() {
        println("Enter values to compute Pythagorean theorem.");
        int a = readInt("a: ");
        int b = readInt("b: ");
        println("c = " + Math.sqrt(a * a + b * b));
    }
}
