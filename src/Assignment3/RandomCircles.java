package Assignment3;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import java.awt.*;

/**
 * Assignment 3
 *
 * Problem 3
 */
public class RandomCircles extends GraphicsProgram {

    private static final int NUM_CIRCLES = 10;

    public void run() {
        for (int i = 0; i < NUM_CIRCLES; i++) {
            int size = rand.nextInt(5, 50);
            int X = rand.nextInt(size, getWidth() - size);
            int Y = rand.nextInt(size, getHeight() - size);
            Color color = rand.nextColor();
            GOval circle = new GOval(size, size);
            circle.setFilled(true);
            circle.setColor(color);
            circle.setLocation(X, Y);
            add(circle);
        }
    }


    private RandomGenerator rand = new RandomGenerator();
}
