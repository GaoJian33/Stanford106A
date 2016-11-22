package Chapter5;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

/**
 * Section Handout #2
 * Problem 2
 */
public class RobotFace extends GraphicsProgram {
    private static final int HEAD_WIDTH = 200;
    private static final int HEAD_HEIGHT = 250;
    private static final int EYE_RADIUS = 20;
    private static final int MOUTH_HEIGHT = 20;
    private static final int MOUTH_WIDTH = 165;

    public void run() {
        int headX = (getWidth() - HEAD_WIDTH) / 2;
        int headY = (getHeight() - HEAD_HEIGHT) / 2;
        GRect head = new GRect(headX, headY, HEAD_WIDTH, HEAD_HEIGHT);
        head.setColor(Color.BLACK);
        head.setFilled(true);
        head.setFillColor(Color.GRAY);
        add(head);

        int eye1X = headX + (HEAD_WIDTH / 4) - EYE_RADIUS;
        int eye2X = eye1X + (HEAD_WIDTH / 2);
        int eyeY = headY + (HEAD_HEIGHT / 4) - EYE_RADIUS;
        GOval eye1 = new GOval(eye1X, eyeY, EYE_RADIUS*2, EYE_RADIUS*2);
        GOval eye2 = new GOval(eye2X, eyeY, EYE_RADIUS*2, EYE_RADIUS*2);
        eye1.setFilled(true);
        eye2.setFilled(true);
        eye1.setColor(Color.YELLOW);
        eye2.setColor(Color.YELLOW);
        add(eye1);
        add(eye2);

        int mouthX = headX + (HEAD_WIDTH - MOUTH_WIDTH) / 2;
        int mouthY = headY + (HEAD_HEIGHT / 4 * 3) - (MOUTH_HEIGHT / 2);
        GRect mouth = new GRect(mouthX, mouthY, MOUTH_WIDTH, MOUTH_HEIGHT);
        mouth.setFilled(true);
        mouth.setColor(Color.WHITE);
        add(mouth);
    }
}
