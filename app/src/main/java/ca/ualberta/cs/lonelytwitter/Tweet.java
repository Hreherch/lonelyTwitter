package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ben on 2016-09-13.
 */
public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    public Tweet( String message ) {
        this.message = message;
    }

    public Tweet( String message, Date date ) {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public ArrayList<Mood> getMoodList() {
        return moodList;
    }

    public void setMoodList(ArrayList<Mood> moodList) {
        this.moodList = moodList;
    }

    public void addMoodToList(Mood mood) {
        this.moodList.add(mood);
    }
}
