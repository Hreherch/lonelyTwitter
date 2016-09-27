package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 2016-09-27.
 */
public class TweetList {
    List<Tweet> tweets = new ArrayList<Tweet>();
    public void add(Tweet tweet) {
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException( "No duplicate tweets." );
        } else {
            tweets.add( tweet );
        }
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains( tweet );
    }

    public Tweet getTweet(int i) {
        return tweets.get( i );
    }

    public void delete(Tweet a) {
        tweets.remove( a );
    }
}