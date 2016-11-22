package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/7/2016.
 */
public class RadioactiveDecay extends ConsoleProgram {
    private static final int INITIAL_ATOMS = 10000;
    private RandomGenerator rand = new RandomGenerator();

    public void run() {
        int currentAtoms = INITIAL_ATOMS;
        int years = 0;
        println("There are " + INITIAL_ATOMS + " atoms initially.");
        while (currentAtoms > 0) {
            int atomsDeacying = 0;
            for(int i = 0; i < currentAtoms; i++) {
                if(rand.nextBoolean()) atomsDeacying++;
            }
            years++;
            currentAtoms -= atomsDeacying;
            println("There are " + currentAtoms + " atoms at the end of year " + years);
        }
    }

}
