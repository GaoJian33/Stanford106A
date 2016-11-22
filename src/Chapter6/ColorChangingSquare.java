package Chapter6;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * Created by Michael on 11/6/2016.
 */
public class ColorChangingSquare extends GraphicsProgram {
    private static final int SQUARE_SIZE = 100;
    private static final int PAUSE_TIME = 600;

    public void run() {
        GRect square = new GRect(SQUARE_SIZE, SQUARE_SIZE);
        square.setFilled(true);
        add(square, (getWidth() - SQUARE_SIZE) / 2,
                    (getHeight() - SQUARE_SIZE) / 2);

        while(true) {
            square.setColor(rgen.nextColor());
            pause(PAUSE_TIME);
        }
    }

    private RandomGenerator rgen = RandomGenerator.getInstance();
}
