package Assignment2;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Created by Michael on 11/3/2016.
 */
public class ProgramHeirarchy extends GraphicsProgram {

    private static final int WIDTH = 120;
    private static final int HEIGHT = 40;
    private static final int SPACING = 20;

    public void run() {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        GRect programBox = new GRect(centerX - (WIDTH / 2), centerY - HEIGHT * 3 / 2, WIDTH, HEIGHT);
        GRect graphicsBox = new GRect(centerX - (WIDTH / 2 + WIDTH + SPACING),
                centerY + HEIGHT / 2, WIDTH, HEIGHT);
        GRect consoleBox = new GRect(centerX - (WIDTH / 2), centerY + HEIGHT / 2, WIDTH, HEIGHT);
        GRect dialogBox = new GRect(centerX + (WIDTH / 2 + SPACING),
                centerY + HEIGHT / 2, WIDTH, HEIGHT);

        GLabel programLabel = new GLabel("Program");
        double pLabelWidth = programLabel.getWidth() / 2;
        double pLabelHeight = programLabel.getAscent() / 2;
        programLabel.setLocation(centerX - pLabelWidth, centerY - HEIGHT + pLabelHeight);
        GLabel graphicsLabel = new GLabel("GraphicsProgram");
        double gLabelWidth = graphicsLabel.getWidth();
        double gLabelHeight = graphicsLabel.getAscent() / 2;
        graphicsLabel.setLocation(centerX - (WIDTH / 2 + WIDTH + SPACING) + ((WIDTH - gLabelWidth) / 2),
                centerY + HEIGHT + gLabelHeight);
        GLabel consoleLabel = new GLabel("ConsoleProgram");
        double cLabelWidth = consoleLabel.getWidth() / 2;
        double cLabelHeight = consoleLabel.getAscent() / 2;
        consoleLabel.setLocation(centerX - cLabelWidth, centerY + HEIGHT + cLabelHeight);
        GLabel dialogLabel = new GLabel("DialogProgram");
        double dLabelWidth = dialogLabel.getWidth();
        double dLabelHeight = dialogLabel.getAscent() / 2;
        dialogLabel.setLocation(centerX + (WIDTH / 2 + SPACING) + ((WIDTH - dLabelWidth) / 2),
                centerY + HEIGHT + dLabelHeight);

        add(programBox);
        add(graphicsBox);
        add(consoleBox);
        add(dialogBox);
        add(programLabel);
        add(graphicsLabel);
        add(consoleLabel);
        add(dialogLabel);

        add(new GLine(centerX, centerY-(HEIGHT / 2), centerX, centerY + (HEIGHT / 2)));
        add(new GLine(centerX, centerY-(HEIGHT / 2), centerX - (WIDTH + SPACING),
                      centerY + (HEIGHT / 2)));
        add(new GLine(centerX, centerY-(HEIGHT / 2), centerX + (WIDTH + SPACING), centerY + (HEIGHT / 2)));

    }
}
