package Chapter4;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * File: Calendar.java
 *
 * Program to print a calendar, according to final constants set
 */
public class Calendar extends GraphicsProgram {
    /* The number of days in the month */
    private static final int DAYS_IN_MONTH = 30;
    /* The day of the week on which the month starts */
    /* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
    private static final int DAY_MONTH_STARTS = 6;
    /* The width in pixels of a day on the calendar */
    private static final int DAY_WIDTH = 40;
    /* The height in pixels of a day on the calendar */
    private static final int DAY_HEIGHT = 30;

    public void run() {
        int dayCounter = 0;
        int emptyDayCounter = 1;

        for (int week = 0; dayCounter < DAYS_IN_MONTH; week++) {
            for (int day = 0; day < 7; day++) {
                add(new GRect(DAY_WIDTH * day, DAY_HEIGHT * week, DAY_WIDTH, DAY_HEIGHT));
                if(emptyDayCounter++ > DAY_MONTH_STARTS && dayCounter++ < DAYS_IN_MONTH) {
                    add(new GLabel(dayCounter + "", DAY_WIDTH * day + 3, DAY_HEIGHT * week + 12));
                }
            }
        }
    }
}
