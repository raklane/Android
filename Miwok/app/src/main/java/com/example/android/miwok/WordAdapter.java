package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    //This is the color resource id for the items in the adapater
    private int mColorResourceId;

    /**
     * This is the default constructor for WordAdapter
     * @param context is used to inflate the layout file
     * @param words is the list of data that we want to populate into these lists
     */
    public WordAdapter(@NonNull Activity context, ArrayList<Word> words, int colorResourceId) {
        /**
         * Here we initialize the ArrayAdapter's internal storage for the context and the list.
         * The second argument is used when the ArrayAdapter is populating a single TextView.
         * Since, it is a Custom adapter, the adapter is not going to use this. So, passing 0.
         */
        super(context,0, words);
        mColorResourceId = colorResourceId;
    }

    /**
     * Provides the view for an AdapterView (ListView, TextView, etc...)
     * @param position The position in the list of data where the new item should be displayed
     * @param convertView The recycled view to populate
     * @param parent The parent ViewGroup that is used for inflation
     * @return The view for the position in the AdapterView
     */
    @NonNull

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //Get the {@link Word} object located at this position in the list
        Word words = getItem(position);

        //find the TextView for default translation in the list_item.xml
        TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        //Assign the default translation from the Word object to this TextView
        defaultTranslationTextView.setText(words.getDefaultTranslation());

        //find the TextView for default translation in the list_item.xml
        TextView miwokTranslationTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        //Assign the default translation from the Word object to this TextView
        miwokTranslationTextView.setText(words.getMiwokTranslation());


        //find the ImageView for the icon of every word
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //Set the image for the word to this ImageView
        if(words.getImageResourceId() != 0){
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(words.getImageResourceId());
        }else
            imageView.setVisibility(View.GONE);

        //Set the background color of the text container (linear layout) in the list
        View textContainer = listItemView.findViewById(R.id.text_Container);
        //Find the color that the resource id maps to
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
