package Chapter4;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Created by Michael on 11/2/2016.
 */
public class CheckerBoard extends GraphicsProgram {

    private static final int SIZE = 38;
    private static final int OFFSET = 4;

    public void run() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                add(new GRect(i * SIZE, j * SIZE, SIZE, SIZE));
                if ((i + j) % 2 == 1) {
                    add(new GOval((i * SIZE) + OFFSET, (j * SIZE) + OFFSET,
                            SIZE - OFFSET * 2, SIZE - OFFSET * 2));
                }
            }
        }
    }
}
