package Chapter8;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

/**
 * Created by Michael on 11/7/2016.
 */
public class DrawingLines extends GraphicsProgram {

    private GLine line;

    public void run() {
        addMouseListeners();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
        add(line);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        line.setEndPoint(e.getX(), e.getY());
    }

}
