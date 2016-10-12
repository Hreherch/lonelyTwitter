package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void setUp() throws Exception {
        Log.d("TAG1", "setUp()");
        solo = new Solo(getInstrumentation(), getActivity() );      // solo can run the app for us now\
    }

    public void testTweet() {
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class ); // check that we are in the right activity

        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Test Tweet!");
        solo.clickOnButton("Save");
        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue( solo.waitForText("Test Tweet!")); // waits to see if texts pops up on screen
        // DOESN'T "WORK" BECAUSE IT'S IN THE EDIT TEXT

        solo.clickOnButton("Clear");
        assertFalse(solo.waitForText("Test Tweet!"));
    }

    public void testClickTweetList() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class );
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Toast Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue( solo.waitForText("Toast Tweet!"));

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertTrue( "Toast Tweet!".equals(tweet.getMessage()) );

        solo.clickInList(0);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        solo.goBack();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class);
    }

    public void testEditTweetVisible() {
        LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class );
        solo.clickOnButton("Clear");

        solo.enterText((EditText) solo.getView(R.id.body), "Toast Tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        solo.enterText((EditText) solo.getView(R.id.body), "my tweet!");
        solo.clickOnButton("Save");

        solo.clearEditText((EditText) solo.getView(R.id.body));
        assertTrue( solo.waitForText("Toast Tweet!"));

        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertTrue( "Toast Tweet!".equals(tweet.getMessage()) );

        solo.clickInList(1);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        assertTrue( solo.waitForText( "Toast Tweet!"));

        solo.goBack();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class );

        solo.clickInList(2);

        solo.assertCurrentActivity("Wrong Activity", EditTweetActivity.class);

        assertTrue( solo.waitForText( "my tweet!"));

        solo.goBack();

        solo.assertCurrentActivity("Wrong Activity", LonelyTwitterActivity.class );


    }
}