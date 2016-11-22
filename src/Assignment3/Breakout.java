package Assignment3;

/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 *
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.MediaTools;
import acm.util.RandomGenerator;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Breakout extends GraphicsProgram {

    /** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;

    /** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;

    /** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;

    /** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;

    /** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;

    /** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;

    /** Separation between bricks */
    private static final int BRICK_SEP = 4;

    /** Width of a brick */
    private static final int BRICK_WIDTH =
            (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

    /** Height of a brick */
    private static final int BRICK_HEIGHT = 8;

    /** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 7;

    /** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;

    /** Offset of the left brick column from the left side */
    private static final int BRICK_X_OFFSET = (WIDTH - ((BRICK_WIDTH * NBRICKS_PER_ROW)
            + ((NBRICKS_PER_ROW - 1) * BRICK_SEP))) / 2;

    /** Number of turns */
    private static final int NTURNS = 3;
    private static final double RATE_OF_SPEED_INCREASE = 0.5;
    private static final int FREQUENCY_OF_SPEED_INCREASE = 10;

    private int turnsRemaining = NTURNS;
    private double lastMouseX;
    private GRect paddle;
    private GOval ball;
    private GLabel scoreLabel;
    private int score;
    private static final int MAXSCOREWIDTH = 50;
    private double vx, vy;
    private GOval[] ballsRemaining;
    private int bricksRemaining;
    private AudioClip bounceSound;
    private int PAUSE = 10;

    private RandomGenerator rand = RandomGenerator.getInstance();


/* Method: run() */
    /** Runs the Breakout program. */
    public void run() {
		/* You fill this in, along with any subsidiary methods */
		setupGame();
        addMouseListeners();
        playGame();
    }

    /** Organizes various aspects of game setup. */
    private void setupGame() {
        bounceSound = MediaTools.loadAudioClip("bounce.au");
        bricksRemaining = 0;
        setupBricks();
        setupRemainingBalls();
        setupBall();
        setupScore();
        setupPaddle();
    }

    /** Puts paddle on the screen. */
    private void setupPaddle() {
        paddle = new GRect(PADDLE_WIDTH / 2,
                HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
        paddle.setFilled(true);
        paddle.setColor(Color.BLACK);
        add(paddle);
    }

    /** Tracks mouse movement and ties that to paddle position. */
    @Override
    public void mouseMoved(MouseEvent e) {
        paddle.move(e.getX() - lastMouseX, 0);
        if(paddle.getX() < 0)
            paddle.setLocation(0, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
        if(paddle.getX() > WIDTH - PADDLE_WIDTH) {
            paddle.setLocation(WIDTH - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
        }
        lastMouseX = e.getX();
    }

    /**
     * Sets up the bricks at the top of the screen.
     */
    private void setupBricks() {
        Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN };
        for(int i = 0; i < NBRICK_ROWS; i++) {
            // set color
            Color color = colors[i/2];
            for (int j = 0; j < NBRICKS_PER_ROW; j++) {
                GRect brick = new GRect(BRICK_X_OFFSET + (j * (BRICK_WIDTH + BRICK_SEP)),
                                        BRICK_Y_OFFSET + (i * (BRICK_HEIGHT + BRICK_SEP)),
                                        BRICK_WIDTH, BRICK_HEIGHT);
                brick.setFilled(true);
                brick.setColor(color);
                add(brick);
                bricksRemaining++;
            }
        }


    }

    /**
     * Sets up three small circles at top of screen, representing balls remaining to play.
     * BUGGY: circles disappear if the ball travels over them. Move to bottom?
     */
    private void setupRemainingBalls() {
        ballsRemaining = new GOval[turnsRemaining];
        for (int i = 0; i < turnsRemaining; i++) {
            ballsRemaining[i] = new GOval(1 + (7 * i), 1, 6, 6);
            add(ballsRemaining[i]);
        }
    }

    /**
     * Sets up the score label.
     */
    private void setupScore() {
        score = 0;
        scoreLabel = new GLabel(score + "", WIDTH - MAXSCOREWIDTH, HEIGHT - 2);
        add(scoreLabel);
    }

    /**
     * Sets up the game ball.
     */
    private void setupBall() {
        ball = new GOval(WIDTH / 2 - BALL_RADIUS, HEIGHT / 2 - BALL_RADIUS,
                BALL_RADIUS * 2, BALL_RADIUS * 2);
        ball.setFilled(true);
        ball.setColor(Color.BLACK);
        add(ball);
        remove(ballsRemaining[--turnsRemaining]);
        vy = 3.0;
        vx = rand.nextDouble(1.0, 3.0);
        if (rand.nextBoolean(0.5)) vx = -vx;
    }

    /**
     * Runs the actual game.
     */
    private void playGame() {
        /* Counts the bounces, for controlling increase in speed. */
        pause(3000);
        int collisionCount = 0;
        while(true) {
            ball.move(vx, vy);
            double x = ball.getX();
            double y = ball.getY();
            if(x <= 1 || x >= WIDTH - (2 * BALL_RADIUS)) vx = -vx;
            if(y <= 1) vy = -vy;
            if(y >= HEIGHT - (2 * BALL_RADIUS)) {
                turnEnded();
                break;
            }
            Collision collision = getCollidingObject(x, y);
            GObject collider;
            boolean side;
            if (collision != null) {
                collider = collision.getObj();
                side = collision.hitSide();
            } else {
                collider = null;
                side = false;
            }
            if(collider != null) {
                if(side) vx = -vx;
                else vy = -vy;
                playSound();
                if(++collisionCount % FREQUENCY_OF_SPEED_INCREASE == 0) {
                    vy += RATE_OF_SPEED_INCREASE;
                }
                if (collider != paddle) {
                    addScore(collider.getColor());
                    remove(collider);
                    bricksRemaining--;
                    if(bricksRemaining == 0) {
                        gameWon();
                        break;
                    }

                }
            }
            pause(PAUSE);
        }
    }

    private void playSound() {
        bounceSound.play();
    }

    private void addScore(Color color) {
        if (color.equals(Color.CYAN)) {
            score += 1;
        } else if (color.equals(Color.GREEN)) {
            score += 2;
        } else if (color.equals(Color.YELLOW)) {
            score += 3;
        } else if (color.equals(Color.ORANGE)) {
            score += 4;
        } else if (color.equals(Color.RED)) {
            score += 5;
        }
        scoreLabel.setLabel(score + "");
    }

    /**
     * Called on a miss, to restart next ball.
     */
    private void turnEnded() {
        remove(ball);
        if(turnsRemaining == 0) {
            gameOver();
            return;
        }
        setupBall();
        playGame();
    }

    /**
     * Called when third miss occurs, game lost.
     */
    private void gameOver() {
        GLabel gameover = new GLabel("GAME OVER");
        gameover.setFont("Times-36");
        add(gameover, (WIDTH - gameover.getWidth()) / 2, (HEIGHT + gameover.getAscent()) / 2);
    }

    /**
     * Called when all bricks dispatched. Game Won.
     */
    private void gameWon() {
        GLabel gameover = new GLabel("YOU WIN!!");
        gameover.setFont("Times-36");
        add(gameover, (WIDTH - gameover.getWidth()) / 2, (HEIGHT + gameover.getAscent()) / 2);
    }

    /**
     * Determines object the ball has collided with.
     * @param x horizontal position of game ball
     * @param y vertical position of game ball
     * @return
     */
    private Collision getCollidingObject(double x, double y) {
        GObject obj = getElementAt(x + BALL_RADIUS, y-1);
        if (obj != null) return new Collision(obj, false);
        obj = getElementAt(x-1, y + BALL_RADIUS);
        if (obj != null) return new Collision(obj, true);
        obj = getElementAt(x + BALL_RADIUS + 1, y + 2 * BALL_RADIUS);
        if (obj != null) return new Collision(obj, false);
        obj = getElementAt(x + 2 * BALL_RADIUS, y + BALL_RADIUS + 1);
        if (obj != null) return new Collision(obj, true);
        return null;
    }

    private class Collision {
        private GObject obj;
        private boolean side;
        public Collision(GObject object, boolean s) {
            obj = object;
            side = s;
        }
        public GObject getObj() {
            return obj;
        }
        public boolean hitSide() {
            return side;
        }
    }
}


