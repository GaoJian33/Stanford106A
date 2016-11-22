package Chapter6;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/7/2016.
 */
public class RandomCard extends ConsoleProgram {

    private String[] suits = { "Clubs", "Hearts", "Spades", "Diamonds" };
    private String[] cards = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
    public void run() {
        println("This program displays a randomly chosen card.");
        RandomGenerator rand = new RandomGenerator();
        int suit = rand.nextInt(4);
        int card = rand.nextInt(13);
        println(cards[card] + " of " + suits[suit]);
    }
}
