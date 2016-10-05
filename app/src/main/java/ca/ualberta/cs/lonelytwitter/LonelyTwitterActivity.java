/*
 * Copyright (C) Bennett Hreherchuk hreherch@ualberta.ca
 * You may use, distribute, and copy all or parts of this code unter the terms and conditions of
 * University of Alberta and the Code of Student Behaviour.
 * You can find the copy of the Code of Student Behaviour at:
 * http://www.governance.ualberta.ca/CodesofConductandResidenceCommunityStandards/CodeofStudentBehaviour.aspx
 */

package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * The main view class of LonelyTwitterProject.
 * It handles all user interactions as well as file manipulations.
 * All files are stored in the form of JSON files stored in the Emulator,
 * accessible from the Android Device Monitor.
 *
 * @see NormalTweet
 * @since 2016 -09-01
 */
public class LonelyTwitterActivity extends Activity {

    /**
     * The file name that LonelyTwitterActivity saves and loads tweets to.
     * @see #loadFromFile()
     * @see #saveInFile()
     */
    private static final String FILENAME = "file.sav";

    /**
     * The EditText that the user writes a tweet into. Initialized in onCreate method.
     * @see Tweet
     * @see #onCreate(Bundle)
     */
    private EditText bodyText;

    /**
     * The ListView that displays tweets to the user. An array adapter is set to this in the
     * onStart method.
     * @see #onResume()
     * @see ListView
     */
    private ListView oldTweetsList;

    /**
     * An array list of tweets that hold the data for the tweets to be set into the ListView.
     * Data is input every time a user writes and saves a tweet.
     * @see #onCreate
     */
    private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

    /**
     * The adapter that connects the oldTweetsList and tweetList to write the model (arrayList) into
     * the view (ListView).
     * @see #onStart
     */
    private ArrayAdapter<Tweet> adapter;

    /**
     * Called when the activity is first created.
     * Sets up the UI, array adapters, and buttons to implement tweeting and seeing tweets
     * @see Activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        bodyText = (EditText) findViewById(R.id.body);
        Button saveButton = (Button) findViewById(R.id.save);
        oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
        Button clearButton = (Button) findViewById(R.id.clear);

        // This constructs functionality when the user clicks the "save" button.
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                String text = bodyText.getText().toString();

                Tweet newTweet = new NormalTweet(text);

                tweetList.add(newTweet);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        });

        // Constructs the functionality for when the user presses "clear"
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                adapter.clear();
                tweetList.clear();
                adapter.notifyDataSetChanged();
                saveInFile();
                bodyText.setText("");
            }
        });
    }

    /**
     * Loads the tweets from file and sets a new array adapter to present tweet data to the user
     * through the listView.
     * @see ArrayAdapter
     * @see ListView
     */
    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this,
                R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);
    }

    /**
     * Uses gson to load tweets from file and store them in the LonelyTwitterActivity class's
     * attributes.
     * @see Gson
     * @throws RuntimeException
     */
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {
            }.getType();

            tweetList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            tweetList = new ArrayList<Tweet>();
        }
    }

    /**
     * Uses gson to save tweets to file (file.sav) with JSON structure and store them in
     * internal storage.
     * @see Gson
     * @throws RuntimeException
     */
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    0);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException();
        }
    }
}