package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kakrya on 6/12/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        ImageView miwokImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            miwokImageView.setImageResource(currentWord.getImageResourceId());
            miwokImageView.setVisibility(View.VISIBLE);
        }else{
            miwokImageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        textContainer.setBackgroundColor(color);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());
        return listItemView;
    }
}
