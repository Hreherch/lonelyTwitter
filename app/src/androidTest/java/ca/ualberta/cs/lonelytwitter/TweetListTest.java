package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Ben on 2016-09-27.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet( "Hello World!" );

        list.add( tweet );
        assertTrue( list.hasTweet( tweet ) );
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet( "Hello World!" );

        assertFalse( list.hasTweet( tweet ) );

        list.add( tweet );
        assertTrue( list.hasTweet( tweet ) );
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet( "Hello World!" );
        Tweet b = new NormalTweet( "Hllo sd" );
        list.add( a );
        list.add( b );

        assertEquals( a, list.getTweet( 0 ) );
        assertEquals( b, list.getTweet( 1 ) );
    }

    public void testDeleteTweet() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet( "Hello World!" );
        list.add( a );
        assertTrue( list.hasTweet( a ) );
        list.delete( a );
        assertFalse( list.hasTweet( a ) );
    }

    // should return Illegal Arg Exception
    public void testDuplicateTweetAddition() {
        TweetList list = new TweetList();
        Tweet a = new NormalTweet( "Hello World!" );
        list.add( a );
        try {
            list.add( a );
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue( true );
        }  catch (Exception e) {
            fail();
        }
    }
}
