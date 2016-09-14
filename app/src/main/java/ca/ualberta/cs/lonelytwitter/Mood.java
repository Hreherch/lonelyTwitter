package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Ben on 2016-09-13.
 */
public abstract class Mood {
    private Date date;

    // Constructor for Mood class
    // Uses time that was passed
    public void Mood(Date date) {
        this.date = date;

    }

    // Constructor for Mood class
    // Uses current time if called without variables
    public void Mood() {
        this.date = new Date();
    }

    // Set the Mood's date
    public void setDate(Date date) {
        this.date = date;
    }

    // get the Mood's date
    public Date getDate() {
        return date;
    }

    // The abstract method for each unique mood
    public abstract String expressMood();

}
