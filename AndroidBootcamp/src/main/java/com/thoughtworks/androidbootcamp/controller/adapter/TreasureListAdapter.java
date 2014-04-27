package com.thoughtworks.androidbootcamp.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.thoughtworks.androidbootcamp.model.Treasure;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;
import com.thoughtworks.androidbootcamp.util.Properties;

import java.util.List;

/**
 * Created by trogdor on 5/03/14.
 */
public class TreasureListAdapter extends BaseAdapter{
    Context context;
    List<Treasure> treasures;

    public TreasureListAdapter(HelloAndroid activity) {
        this.context = activity;
        this.treasures = activity.getTreasures();
    }

    @Override
    public int getCount() {
        return treasures.size();
    }

    @Override
    public Object getItem(int i) {
        return treasures.get(i);
    }

    @Override
    public long getItemId(int i) {
        return treasures.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = (view == null) ? new ImageView(context) : (ImageView) view;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        String url = getUrlForTreasure(treasures.get(i));
        Picasso.with(context).load(url).resize(640, 480).centerCrop().into(imageView);
        return imageView;
    }

    public String getUrlForTreasure(Treasure treasure) {
        return Properties.SERVICE_URL + "/" + treasure.getUrl().replace("public/", "");
    }
}
