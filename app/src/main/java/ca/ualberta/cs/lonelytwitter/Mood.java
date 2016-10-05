package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Abstract base class that provides structure for moods - a string representation of a feeling -
 * that can be used with Tweets. Moods also use a date to capture when they were first created
 * because carrying around and tracking emotional baggage is really important.
 * @see Tweet
 */
public abstract class Mood {
    private Date date;

    /**
     * Creates a Mood with the given Date object.
     *
     * @param date a Date object with the time you wish to specify on the Mood.
     * @see Date
     */
    public void Mood(Date date) {
        this.date = date;
    }


    /**
     * Creates a Mood with the date being the time it was created.
     *
     * @see Date
     */
    public void Mood() {
        this.date = new Date();
    }


    /**
     * Sets date.
     * @see #Mood
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }


    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }


    /**
     * Abstract method that returns a string that represents a concrete mood.
     *
     * @return The string representation of a mood.
     */
    public abstract String expressMood();
}
