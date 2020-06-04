package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    Context context;

    public WordAdapter(Activity context, ArrayList<Word> word) {
        super(context, 0, word);
        this.context = context;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Check if the existing view is being reused. If not then inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Get the Word {@Words} at position in the list
        final Word currentWord = getItem(position);

        TextView mivokTranslationView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        mivokTranslationView.setText(currentWord.getmMivokTranslation());

        TextView defaultTranslationView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTranslationView.setText(currentWord.getmDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if(currentWord.getmImageId() != 0){
            imageView.setImageResource(currentWord.getmImageId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        /*final MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(context, currentWord.getmAudioResourceId());
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Playing audio", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();
            }
        });*/

        LinearLayout listItemTextView = listItemView.findViewById(R.id.list_item_text_view);
        switch (context.getClass().getSimpleName()){
            case "NumbersActivity":
                listItemTextView.setBackgroundColor(context.getResources().getColor(R.color.category_numbers));
                break;
            case "PhrasesActivity":
                listItemTextView.setBackgroundColor(context.getResources().getColor(R.color.category_phrases));
                break;
            case "ColorsActivity":
                listItemTextView.setBackgroundColor(context.getResources().getColor(R.color.category_colors));
                break;
            case "FamilyMembersActivity":
                listItemTextView.setBackgroundColor(context.getResources().getColor(R.color.category_family));
                break;
        }


        return listItemView;
    }
}
