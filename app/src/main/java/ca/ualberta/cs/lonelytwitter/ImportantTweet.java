package ca.ualberta.cs.lonelytwitter;

/**
 * An important tweet is more important that a NormalTweet. This may be an oxymoron but it makes
 * users feel better knowing that their tweets are validated in some way.
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet with the given message.
     *
     * @param message the message the ImportantTweet will have.
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Returns true because this is an important tweet.
     * @see Tweet
     */
    //Leave @override to let others know we are overriding something in the parent class
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }


}
