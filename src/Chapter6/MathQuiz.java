package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/7/2016.
 */
public class MathQuiz extends ConsoleProgram {
    private static final int NUM_PROBLEMS = 5;
    private RandomGenerator rand = new RandomGenerator();

    public void run() {
        println("Welcome to Math Quiz");
        for (int i = 0; i < NUM_PROBLEMS; i++) {
            int x, y, sum;
            boolean addition = rand.nextBoolean();
            do {
                x = rand.nextInt(1, 20);
                y = rand.nextInt(1, 20);
                sum = addition ? x + y : x - y;
            } while (sum < 0 || sum > 20);

            promptForAnswer(x, y, addition, sum);

        }
    }

    private void promptForAnswer(int x, int y, boolean add, int sum) {
        int response;
        int wrongcount = 0;
        while(true) {
            response = readInt("What is " + x +
                    (add ? " + " : " - ") + y + "? ");
            if(response == sum) break;
            wrongcount++;
            if(wrongcount > 2) {
                println("The correct answer is " + sum);
                return;
            }
            println("That's incorrect. Try again....");
        }
        println(rights[rand.nextInt(rights.length)]);
    }

    private String[] rights = {
            "Good job!",
            "That's it.",
            "Nicely done.",
            "Correct!!",
            "Way to go!",
            "Great!",
            "Way to go!"
    };
}
