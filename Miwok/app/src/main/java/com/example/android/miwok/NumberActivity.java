package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        //Initialize the array for numbers
        String[] wordsArray = new String[] {"one","two","three","four","five","six","seven","eight","nine","ten"};
        ArrayList<String> words = new ArrayList<String>();
        words.addAll(Arrays.asList(wordsArray));

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);


        for(int index = 0; index<words.size() ;index++){
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }
    }
}
