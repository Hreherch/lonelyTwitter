package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Test suite for TweetLists
 * @see TweetList
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    /**
     * Tests adding a tweet to a TweetList. Ensures that the list has the given tweet.
     */
    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello World!");

        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * tests that a TweetList has a tweet after being given it and not before.
     */
    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("Hello World!");

        assertFalse(list.hasTweet(tweet));

        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * Tests that a tweetList can get a tweet after it has been added to the TweetList
     */
    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello World!");
        Tweet b = new NormalTweet("Hllo sd");
        list.add(a);
        list.add(b);

        assertEquals(a, list.getTweet(0));
        assertEquals(b, list.getTweet(1));
    }

    /**
     * test that a TweetList no longer has a tweet after deleting it
     */
    public void testDeleteTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello World!");
        list.add(a);
        assertTrue(list.hasTweet(a));
        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * Tests that adding a duplicate Tweet to a TweetList throws an exception
     */
    public void testDuplicateTweetAddition() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello World!");
        list.add(a);
        try {
            list.add(a);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * test that tweets are ordered regardless of the order they were input
     */
    public void testOrderedTweetReturn() {
        TweetList list = new TweetList();
        GregorianCalendar calendar = new GregorianCalendar();
        Tweet a = new NormalTweet("Hello World!");
        Tweet b = new NormalTweet("nothing interesting");
        calendar.add(Calendar.DATE, -1);
        b.setDate(calendar.getTime());
        Tweet c = new NormalTweet("ugh, life.");
        calendar.add(Calendar.DATE, -1);
        c.setDate(calendar.getTime());

        list.add(b);
        list.add(c);
        list.add(a);

        assertEquals(a, list.getTweets().get(0));
        assertEquals(b, list.getTweets().get(1));
        assertEquals(c, list.getTweets().get(2));

    }

    /**
     * Tests that the TweetList properly counts the number of tweets within in, regardless
     * of recent additions and deletions.
     */
    public void testCountingTweets() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet("Hello World!");
        Tweet b = new NormalTweet("nothing interesting");
        Tweet c = new NormalTweet("ugh, life.");

        assertEquals(0, list.getCount());
        list.add(a);
        assertEquals(1, list.getCount());
        list.add(b);
        list.add(c);
        assertEquals(3, list.getCount());
        list.delete(a);
        assertEquals(2, list.getCount());
        list.removeTweet(b);
        list.removeTweet(c);
        assertEquals(0, list.getCount());
    }
}

