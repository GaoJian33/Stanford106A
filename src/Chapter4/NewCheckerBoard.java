package Chapter4;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Created by Michael on 11/2/2016.
 */
public class NewCheckerBoard extends GraphicsProgram {

    private static int SIZE;
    private static final int OFFSET = 4;

    public void run() {
        SIZE = (getHeight() - 1) / 8;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                GRect rect = new GRect(i * SIZE, j * SIZE, SIZE, SIZE);
                rect.setFilled((i + j) % 2 == 1);
                add(rect);
            }
        }
    }
}
