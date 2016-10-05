package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class TweetList {

    /**
     * The Tweets that make up a tweet list. These tweets will be sorted chronologically.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Adds a tweet to the tweetList to be be a part of the sea of tweets that is a tweetlist.
     *
     * @param tweet the tweet you wish to add to a tweetlist.
     */
    @SuppressWarnings("unchecked")
    public void add(Tweet tweet) {
        if (hasTweet(tweet)) {
            throw new IllegalArgumentException("No duplicate tweets.");
        } else {
            tweets.add(tweet);
            Collections.sort(tweets);
        }
    }

    /**
     * Returns true if the tweet is contained within the tweetlist.
     *
     * @param tweet the tweet you wish to see if it is in the tweetlist
     * @return true if tweet is contain in tweetlist, otherwise false.
     */
    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    /**
     * Gets the i-th tweet in the TweetList. This is in chronological order, so this may be
     * the i-th tweet ever made by your lonelyTwitter.
     *
     * @param i the
     * @return the tweet
     */
    public Tweet getTweet(int i) {
        return tweets.get(i);
    }

    /**
     * Deletes the specified tweet object from the TweetList.
     *
     * @deprecated
     * @param a the tweet you wish to remove from the TweetList
     */
    public void delete(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Has same functionality as delete(Tweet), except is more explicit in what it does. It delete
     * a specified tweet object from the TweetList
     * @see #delete(Tweet)
     * @param a the a
     */
    public void removeTweet(Tweet a) {
        tweets.remove(a);
    }

    /**
     * Returns the number of tweets currently in the tweetList
     *
     * @return the count of tweets in the TweetList.
     */
    public int getCount() {
        return tweets.size();
    }

    /**
     * Returns a list of Tweet that are the same tweets in the TweetList.
     *
     * @return a list of tweets in the TweetList
     */
    public List<Tweet> getTweets() {
        return tweets;
    }
}
