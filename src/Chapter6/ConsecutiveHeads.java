package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/7/2016.
 */
public class ConsecutiveHeads extends ConsoleProgram {
    private static final int HEAD_GOAL = 5;
    public void run() {
        RandomGenerator rand = new RandomGenerator();
        int flipcount = 0;
        int headcount = 0;
        while (headcount < HEAD_GOAL) {
            boolean flip = rand.nextBoolean();
            if(flip) {
                println("Heads");
                headcount++;
            } else {
                println("Tails");
                headcount = 0;
            }
            flipcount++;
        }
        println("It took " + flipcount + " flips to get " + HEAD_GOAL + " consecutive heads.");
    }
}
