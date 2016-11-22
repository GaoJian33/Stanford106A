package Assignment4;

import acm.graphics.GCanvas;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;

/**
 * Created by Michael on 11/11/2016.
 */
public class HangmanCanvas extends GCanvas {
    private GLine scaffold, beam, rope, body, rarm, larm, rhand, lhand,
            rhip, lhip, rleg, lleg, rfoot, lfoot;
    private GOval head;
    private int wrongGuessCount;
    private GLabel word, wrongGuessesLabel, gameOverLabel;
    private String wrongGuesses;

    public HangmanCanvas() {

    }
    /** Resets the display so that only the scaffold appears */
    public void reset() {
		/* You fill this in */
		if(gameOverLabel == null) {
            setUpCanvas();
        }
		wrongGuessCount = 0;
        wrongGuesses = "";
		wrongGuessesLabel.setLabel(wrongGuesses);
        gameOverLabel.setVisible(false);
        head.setVisible(false);
        body.setVisible(false);
        rarm.setVisible(false);
        larm.setVisible(false);
        rhand.setVisible(false);
        lhand.setVisible(false);
        rhip.setVisible(false);
        lhip.setVisible(false);
        rleg.setVisible(false);
        lleg.setVisible(false);
        rfoot.setVisible(false);
        lfoot.setVisible(false);

    }
    private void setUpCanvas() {
        wrongGuessCount = 0;
        wrongGuesses = "";
        int centerline = getWidth() / 2;
        int topbeam = getHeight() / 6;
        word = new GLabel("", centerline - BEAM_LENGTH, getHeight() / 5 * 4);
        word.setFont("SERIF-32");
        add(word);
        wrongGuessesLabel = new GLabel(wrongGuesses, centerline - BEAM_LENGTH, getHeight() / 5 * 4 + WRONGGUESSESOFFSET);
        add(wrongGuessesLabel);
        gameOverLabel = new GLabel("", centerline, getHeight() / 2);
        gameOverLabel.setFont("SERIF-56");
        gameOverLabel.setVisible(false);
        add(gameOverLabel);
        scaffold = new GLine(centerline - BEAM_LENGTH, topbeam,
                centerline - BEAM_LENGTH, topbeam + SCAFFOLD_HEIGHT);
        add(scaffold);
        beam = new GLine(centerline - BEAM_LENGTH, topbeam,
                centerline, topbeam);
        add(beam);
        rope = new GLine(centerline, topbeam, centerline, topbeam + ROPE_LENGTH);
        add(rope);
        head = new GOval(centerline - HEAD_RADIUS, topbeam + ROPE_LENGTH,
                HEAD_RADIUS * 2, HEAD_RADIUS * 2);

        add(head);
        body = new GLine(centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS,
                centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);

        add(body);
        rarm = new GLine(centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
                centerline + UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);

        add(rarm);
        larm = new GLine(centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
                centerline - UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD);

        add(larm);
        rhand = new GLine(centerline + UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
                centerline + UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);

        add(rhand);
        lhand = new GLine(centerline - UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD,
                centerline - UPPER_ARM_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);

        add(lhand);

        rhip = new GLine(centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
                centerline + HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);

        add(rhip);
        lhip = new GLine(centerline, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
                centerline - HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH);

        add(lhip);
        rleg = new GLine(centerline + HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
                centerline + HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);

        add(rleg);
        lleg = new GLine(centerline - HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH,
                centerline - HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);

        add(lleg);

        rfoot = new GLine(centerline + HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
                centerline + HIP_WIDTH + FOOT_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);

        add(rfoot);
        lfoot = new GLine(centerline - HIP_WIDTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH,
                centerline - HIP_WIDTH - FOOT_LENGTH, topbeam + ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH + LEG_LENGTH);

        add(lfoot);
    }
    /**
     * Updates the word on the screen to correspond to the current
     * state of the game.  The argument string shows what letters have
     * been guessed so far; unguessed letters are indicated by hyphens.
     */
    public void displayWord(String word) {
		/* You fill this in */
		this.word.setLabel(word);
    }

    /**
     * Updates the display to correspond to an incorrect guess by the
     * user.  Calling this method causes the next body part to appear
     * on the scaffold and adds the letter to the list of incorrect
     * guesses that appears at the bottom of the window.
     */
    public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		showWrongLetter(letter);
        wrongGuessCount++;
        switch (wrongGuessCount) {
            case 1:
                head.setVisible(true);
                break;
            case 2:
                body.setVisible(true);
                break;
            case 3:
                larm.setVisible(true);
                lhand.setVisible(true);
                break;
            case 4:
                rarm.setVisible(true);
                rhand.setVisible(true);
                break;
            case 5:
                rhip.setVisible(true);
                rleg.setVisible(true);
                break;
            case 6:
                lhip.setVisible(true);
                lleg.setVisible(true);
                break;
            case 7:
                lfoot.setVisible(true);
                break;
            case 8:
                rfoot.setVisible(true);
                break;
            default:
        }
    }
    public void gameOver(boolean won) {
        if(won) {
            gameOverLabel.setLabel("You Won!!");
        } else {
            gameOverLabel.setLabel("You Lost.");
        }
        gameOverLabel.setLocation((getWidth() - gameOverLabel.getWidth()) / 2,
                (getHeight() - gameOverLabel.getAscent()) / 2);
        gameOverLabel.setVisible(true);
    }
    private void showWrongLetter(char letter) {
        wrongGuesses += letter;
        wrongGuessesLabel.setLabel(wrongGuesses);
    }
    /* Constants for the simple version of the picture (in pixels) */
    private static final int SCAFFOLD_HEIGHT = 360;
    private static final int BEAM_LENGTH = 144;
    private static final int ROPE_LENGTH = 18;
    private static final int HEAD_RADIUS = 36;
    private static final int BODY_LENGTH = 144;
    private static final int ARM_OFFSET_FROM_HEAD = 28;
    private static final int UPPER_ARM_LENGTH = 72;
    private static final int LOWER_ARM_LENGTH = 44;
    private static final int HIP_WIDTH = 36;
    private static final int LEG_LENGTH = 108;
    private static final int FOOT_LENGTH = 28;
    private static final int WRONGGUESSESOFFSET = 44;

}

