package Chapter5;

import acm.program.ConsoleProgram;

/**
 * Art & Science of Java Chapter 5, Programming Exercises
 */
public class ProgrammingExercises extends ConsoleProgram {

    public void run() {
        double phi = (1 + Math.sqrt(5)) / 2;
        println("Phi, the Golden Ratio, equals: " + phi);

        println("Enter coefficients for the quadratic equation: ");
        int a = readInt("a: ");
        int b = readInt("b: ");
        int c = readInt("c: ");
        int under = b * b - (4 * a * c);
        if(under < 0) {
            println("No real solution exists for this problem.");
        } else {
            double first = (-b + Math.sqrt(under)) / (2 * a);
            println("The first solution is " + first);
            double second = (-b - Math.sqrt(under)) / (2 * a);
            println("The second solution is " + second);

        }


        for (int i = 0; i < 11; i++) {
            println(raiseIntToPower(2, i));
        }

        for (int i = -4; i < 5; i++) {
            println(raiseRealToPower(Math.PI, i));
        }
    }

    private int raiseIntToPower(int n, int k) {
        int response = 1;
        for(int i = 0; i < k; i++) {
            response *= n;
        }
        return response;
    }

    private double raiseRealToPower(double x, int k) {
        boolean negative = false;
        if(k < 0) {
            negative = true;
            k = -k;
        }
        double response = 1.0;
        for(int i = 0; i < k; i++) {
            response *= x;
        }
        if(negative) return 1 / response;
        else return response;
    }
}
