package Assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * File: BrickPyramid
 *
 * Programming Assignment 2
 *
 * Problem 1, 2
 */
public class BrickPyramid extends GraphicsProgram {

    public static final int BRICK_WIDTH = 35;
    public static final int BRICK_HEIGHT = 15;
    public static final int BRICKS_IN_BASE = 18;

    public void run() {
        int centerX = getWidth() / 2;
        int bottomY = getHeight() - 1;
        for (int i = 1; i <= BRICKS_IN_BASE; i++) {
            int startingX = centerX - (i * BRICK_WIDTH / 2);
            int Y = bottomY - ((BRICKS_IN_BASE - i + 1) * BRICK_HEIGHT);
            for (int j = 0; j < i; j++) {
                add(new GRect(startingX + (BRICK_WIDTH * j), Y, BRICK_WIDTH, BRICK_HEIGHT));
            }
        }

        int centerY = getHeight() / 2;
        double BIG = 72;
        double MED = BIG * 0.65;
        double SMALL = BIG * 0.3;
        GOval big = new GOval(centerX - (BIG / 2), centerY - (BIG / 2), BIG, BIG);
        big.setColor(Color.RED);
        big.setFilled(true);
        GOval med = new GOval(centerX - (MED / 2), centerY - (MED / 2), MED, MED);
        med.setColor(Color.WHITE);
        med.setFilled(true);
        GOval small = new GOval(centerX - (SMALL / 2), centerY - (SMALL / 2), SMALL, SMALL);
        small.setColor(Color.RED);
        small.setFilled(true);
        add(big);
        add(med);
        add(small);
    }
}
