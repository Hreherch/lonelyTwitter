package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Ben on 2016-09-13.
 */
public class ImportantTweet extends Tweet {

    public ImportantTweet(String message) {
        super(message);
    }

    //Leave @override to let others know we are overriding something in the parent class
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

}
