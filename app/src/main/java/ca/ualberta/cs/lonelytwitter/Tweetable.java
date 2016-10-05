package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Interface that represents an object can be tweetable. Generally for use with a ListView to
 * represents tweets.
 * @see Tweet
 */
public interface Tweetable {

    /**
     * Gets the Tweetable object's message.
     *
     * @return the message of the tweet.
     */
    public String getMessage();

    /**
     * Gets the Tweetable object's date.
     *
     * @return the date associated with the Tweetable object.
     */
    public Date getDate();
}
