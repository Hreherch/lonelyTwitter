package ca.ualberta.cs.lonelytwitter;

/**
 * A normal tweet is unimportant. Sadly every user's Tweet in LonelyTwitter is a normal tweet
 * so they never get to experience the joys of having an important tweet. No user knows this though
 * so they feel validated anyway.
 * @see Tweet
 */
public class NormalTweet extends Tweet {

    /**
     * Instantiates a new Normal tweet with the given message.
     *
     * @param message the message you wish the Normal tweet to have.
     */
    public NormalTweet(String message) {
        super(message);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
