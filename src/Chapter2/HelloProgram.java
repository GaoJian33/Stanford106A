package Chapter2;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;


/**
 * This program started as a "hello, world" program.
 * It has been extended as a place to experiment with the acm graphics library.
 *
 * Includes:
 * Art and Science of Java
 * Chapter 2
 * Programming Exercises 1, 4
 *
 */


public class HelloProgram extends GraphicsProgram {
    public void run() {
        add(new GLabel("I love coffee", 100, 75));
        GLabel label = new GLabel("Michael Overman", 300, 295);
        label.setFont("Serif-18");
        label.setColor(Color.CYAN);
        add(label);

        // draw a robot
        add(new GOval(120, 20, 40, 40));
        add(new GRect(100, 60, 80, 110));
        add(new GRect(115, 170, 15, 70));
        add(new GRect(150, 170, 15, 70));

        // draw a snowman
        add(new GOval(30, 20, 40, 40));
        add(new GOval(20, 60, 60, 60));
        add(new GOval(10, 120, 80, 80));
        add(new GOval(45, 45, 10, 10)); // mouth
        add(new GLabel("v", 48, 43)); // nose
        add(new GOval(40, 26, 8, 8)); // eyes
        add(new GOval(52, 26, 8, 8));

        //Buttons
        GRect button1 = new GRect(45, 67, 10, 10);
        GRect button2 = new GRect(45, 84, 10, 10);
        GRect button3 = new GRect(45, 101, 10, 10);
        button1.setFilled(true);
        button2.setFilled(true);
        button3.setFilled(true);
        add(button1);
        add(button2);
        add(button3);




    }
}
