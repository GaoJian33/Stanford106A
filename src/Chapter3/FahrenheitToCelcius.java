package Chapter3;

import acm.program.ConsoleProgram;

/**
 * Created by Michael on 11/1/2016.
 */
public class FahrenheitToCelcius extends ConsoleProgram {
    public void run() {
        println("This program convert Fahrenheit to Celsius.");
        double fahr = readDouble("Enter Fahrenheit temperature: ");
        double celsius = (fahr - 32) * 5 / 9;
        println("Celsius = " + celsius);

        int man = 1;
        int wives = 7;
        int sacks = 7 * wives;
        int cats = 7 * sacks;
        int kits = 7 * cats;
        int total = man + wives + sacks + cats + kits;
        println(total + " were coming from St. Ives");
    }
}
