package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/7/2016.
 */
public class MonteCarloPi extends ConsoleProgram {
    private RandomGenerator rand = new RandomGenerator();
    private static final int TRIALS = 1000000;
    public void run() {
        int inCircle = 0;
        for (int i = 0; i < TRIALS; i++) {
            double x = rand.nextDouble(-1.0, 1.0);
            double y = rand.nextDouble(-1.0, 1.0);
            if((x*x) + (y*y) < 1.0) inCircle++;
        }
        double pi = (double) inCircle / TRIALS * 4;
        println("Monte Carlo approximation of PI: " + pi);
    }
}
