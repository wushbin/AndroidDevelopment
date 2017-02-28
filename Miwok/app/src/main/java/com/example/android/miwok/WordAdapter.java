package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by wushbin on 2/10/17.
 */


public class WordAdapter extends ArrayAdapter <Word>{

    private  int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourseId) {
        super(context, 0, words);
        mColorResourceId = colorResourseId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        TextView miwokWord = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWord.setText(currentWord.getMiwokTranslation());

        TextView englishWord = (TextView) listItemView.findViewById(R.id.default_text_view);
        englishWord.setText(currentWord.getEnglishTranslation());

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image_view);

        if(currentWord.hasImage()){
            iconView.setImageResource(currentWord.getResourseId());
            iconView.setVisibility(View.VISIBLE);
        }
        else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);
        return listItemView;


    }









}
