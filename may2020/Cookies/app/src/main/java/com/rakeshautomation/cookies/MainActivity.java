package com.rakeshautomation.cookies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * On click of button
     */
    public void eatCookie(View view){
        //Change image
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.after_cookie);
        //Change text
        TextView hungryTextView = (TextView) findViewById(R.id.hungry_text_view);
        hungryTextView.setText("I'm so full");
        Log.i("Actions", "Cookie was eaten.");
    }

}
