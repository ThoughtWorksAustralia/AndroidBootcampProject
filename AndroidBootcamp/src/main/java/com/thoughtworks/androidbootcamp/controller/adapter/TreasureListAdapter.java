package com.thoughtworks.androidbootcamp.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.thoughtworks.androidbootcamp.R;

import java.util.List;

/**
 * Created by trogdor on 5/03/14.
 */
public class TreasureListAdapter extends BaseAdapter{
    Context context;
    String[] treasurePaths;

    public TreasureListAdapter(Context context, String[] paths) {
        this.context = context;
        this.treasurePaths = paths;
    }

    @Override
    public int getCount() {
        return treasurePaths.length;
    }

    @Override
    public Object getItem(int i) {
        return treasurePaths[i];
    }

    @Override
    public long getItemId(int i) {
        return treasurePaths[i].hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (view == null) ? new ImageView(context) : (ImageView) view;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Picasso.with(context).load(treasurePaths[i]).resize(640, 480).centerCrop().into(imageView);
        return imageView;
    }
}
