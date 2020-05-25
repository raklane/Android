package com.rakeshautomation.sampleapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*TextView textView = new TextView(this);
        textView.setText("Rakesh Kumar!");
        textView.setTextColor(Color.parseColor("#FF3D00"));
        textView.setTextSize(Float.parseFloat("48"));*/

        setContentView(R.layout.activity_main);
    }
}
