package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdulkarim on 3/12/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResource){
        super(context, 0, words);
        mColorResourceId = colorResource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_items, parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.english_text_view);
        defaultTranslation.setText(currentWord.getDefaultTranslation());

        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTranslation.setText(currentWord.getMiwokTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if(currentWord.hasImage()){
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

        View listView = listItemView.findViewById(R.id.layout_text_views);
        if (this.getContext() instanceof ColorsActivity) {
            listView.setBackgroundColor(Color.parseColor("#8800A0"));
        } else if (this.getContext() instanceof NumbersActivity) {
            listView.setBackgroundColor(Color.parseColor("#FD8E09"));
        } else if (this.getContext() instanceof PhrasesActivity) {
            listView.setBackgroundColor(Color.parseColor("#16AFCA"));
        } else if (this.getContext() instanceof FamilyActivity) {
            listView.setBackgroundColor(Color.parseColor("#379237"));
        }

        return listItemView;
    }
}
