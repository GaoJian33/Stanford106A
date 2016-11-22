package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/6/2016.
 */
public class RollDice extends ConsoleProgram {

    private static final int NUM_SIDES = 6;

    public void run() {
        int numDice = readInt("Number of dice: ");
        int maxRoll = numDice * NUM_SIDES;
        int numRolls = 0;
        while(true) {
            int roll = rollDice(numDice);
            numRolls++;
            if (roll == maxRoll) break;
//            println("Rolled " + roll);
        }
        println("Rolled " + maxRoll + " after " + numRolls + " rolls.");
    }

    private int rollDice(int numDice) {
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += rgen.nextInt(1, NUM_SIDES);
        }
        return total;
    }

    private RandomGenerator rgen = RandomGenerator.getInstance();
}
