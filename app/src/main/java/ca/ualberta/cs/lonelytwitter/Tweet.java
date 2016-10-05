package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Abstract representation of a Tweet (see Twitter.org for some idea of what this is). This
 * implementation has no consideration for the user that tweets the tweet.
 *
 * @see LonelyTwitterActivity
 * @see TweetTooLongException
 * @see Mood
 */
public abstract class Tweet implements Tweetable, Comparable {

    /**
     * A message for the Tweet. Typically not longer than 140 characters but there is always
     * rumors abound about this restriction being lifted.
     */
    private String message;

    /**
     * The date that one twats, or tweets. This can be changed to make it look like you predicted
     * the future.
     * @see #setDate(Date)
     */
    private Date date;

    /**
     * An array of moods associated with a tweet. These moods have no purpose for the Tweet itself,
     * which may be some commentary on the socio-norms of Twitter as a whole.
     */
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    /**
     * Instantiates a new Tweet with the given message. Date is based on the current time.
     *
     * @param message the message you wish the tweet to hold.
     */
    public Tweet(String message) {
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet with a given message and date.
     *
     * @param message the message the tweet will contain
     * @param date    the date the tweet will be associated with
     * @throws RuntimeException if the tweet is too long.
     */
    public Tweet(String message, Date date) {
        try {
            setMessage(message);
        } catch (TweetTooLongException e) {
            throw new RuntimeException();
        }
        this.date = date;
    }

    /**
     * This should return true if a Tweet is important.
     *
     * @return a boolean representing if a tweet is important
     */
    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    /**
     * Sets the date that the tweet was tweeted/created. This is important for the ordering of the
     * tweets.
     *
     * @see Date
     * @param date the date that is associated with the tweet
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the message of the Tweet object.
     *
     * @param message the message that the tweet should represent
     * @throws TweetTooLongException if the tweet is too long (i.e. more than 140 characters)
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Gets mood list.
     *
     * @return the mood list
     */
    public ArrayList<Mood> getMoodList() {
        return moodList;
    }

    /**
     * Sets the moods associated with this tweet to the list of moods provided
     *
     * @see Mood
     * @param moodList the mood list of moods you wish the tweet to have.
     */
    public void setMoodList(ArrayList<Mood> moodList) {
        this.moodList = moodList;
    }

    /**
     * Add a Mood to be associated with the Tweet. Will add the mood to the list of moods associated
     * with this tweet.
     *
     * @see Mood
     * @param mood the mood to be associated with the tweet.
     */
    public void addMoodToList(Mood mood) {
        this.moodList.add(mood);
    }

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }


    /**
     * Allows tweets to be compared on a chronological ordering by returning a integer representing
     * if a Tweet is before or after another Tweet.
     *
     * @param o another Tweet object to compare this Tweet to.
     * @return an integer representing the .compareTo of the Tweet's date object.
     * @see Date
     * @see Comparable
     */
    public int compareTo(Object o) {
        Tweet aTweet = (Tweet) o;
        return aTweet.getDate().compareTo(this.getDate());
    }

}
