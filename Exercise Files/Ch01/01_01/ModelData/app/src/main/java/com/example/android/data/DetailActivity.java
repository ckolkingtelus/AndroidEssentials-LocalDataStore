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
    }

    String testString = CONSTANT_STRING_TEST;
    Log.d("LDS-Kolking", testString);

}
