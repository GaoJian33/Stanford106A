package Section6;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * Created by Michael on 11/17/2016.
 */
public class FlipHorizontal extends GraphicsProgram {
    private GImage image;

    public void run() {
        image = new GImage("CS223A.jpg");
        add(image);
        while(true) {
            waitForClick();
            image = flipHorizontal(image);
            add(image);
        }
    }

    private GImage flipHorizontal(GImage i) {
        GImage img = i;
        int[][] arr = img.getPixelArray();
        for(int row = 0; row < arr.length; row++) {
            flipRow(arr[row]);
        }

        return new GImage(arr);
    }

    private void flipRow(int[] row) {
        for(int i= 0; i < row.length / 2; i++) {
            int temp = row[i];
            row[i] = row[row.length - i - 1];
            row[row.length - i - 1] = temp;
        }
    }
}
