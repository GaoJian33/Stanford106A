package Chapter8;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Michael on 11/7/2016.
 */
public class DragObjects extends GraphicsProgram {

    private GObject gobj;
    private double lastX;
    private double lastY;

    public void run() {
        GRect rect = new GRect(100, 100, 150, 100);
        rect.setFilled(true);
        rect.setColor(Color.RED);
        add(rect);
        GOval oval = new GOval(300, 115, 100, 70);
        oval.setFilled(true);
        oval.setColor(Color.GREEN);
        GFace face = new GFace(100, 100);
        add(face, 100, 100);
        add(oval);
        addMouseListeners();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
        gobj = getElementAt(lastX, lastY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (gobj != null) {
            gobj.move(e.getX() - lastX, e.getY() - lastY);
            lastX = e.getX();
            lastY = e.getY();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gobj != null) gobj.sendToFront();
    }
}
