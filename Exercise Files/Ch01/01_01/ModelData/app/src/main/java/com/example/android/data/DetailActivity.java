package com.example.android.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

//    private static final String CONSTANT_STRING_TEST = "this is a test string value for a constant after I used the \'intention action\'.";
    private static final String CONSTANT_STRING_TEST = "This is a test string value for a constant.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // "CORRECTION A"
        String testString = CONSTANT_STRING_TEST;
        Log.d("LDS-Kolking", testString);
    }
// STUPID!! of course, can't have code simply running as part of the class definition;  the code needs to go into a component method!!
    // see "CORRECTION A" above...
//    String testString = CONSTANT_STRING_TEST;
//    Log.d("LDS-Kolking", testString);

}
