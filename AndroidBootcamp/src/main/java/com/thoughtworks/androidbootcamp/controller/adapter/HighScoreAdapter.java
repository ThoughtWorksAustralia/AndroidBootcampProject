package com.thoughtworks.androidbootcamp.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thoughtworks.androidbootcamp.model.Score;

import java.util.List;

/**
 * Created by macosgrove on 21/04/2014.
 */
public class HighScoreAdapter  extends BaseAdapter {
    Context mContext;
    List<Score> mHighScores;

    public HighScoreAdapter(Context context, List<Score> highScores) {
        this.mContext = context;
        this.mHighScores = highScores;
    }

    @Override
    public int getCount() {
        return mHighScores.size();
    }

    @Override
    public Object getItem(int i) {
        return mHighScores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mHighScores.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (view == null) ? new TextView(mContext) : (TextView) view;
        Score score = mHighScores.get(i);
        textView.setText(score.getName() + " : " + score.getScore());
        return textView;
    }

}
