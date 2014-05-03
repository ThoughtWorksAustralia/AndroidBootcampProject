package com.thoughtworks.androidbootcamp.controller.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.MapFragment;

import com.thoughtworks.androidbootcamp.R;


public class TreasureMapFragment extends Fragment {

    private MapFragment mMapFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_map, container, false);
        addMapFragment();

        return mView;
    }

    private void addMapFragment() {
        mMapFragment = MapFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.map_container, mMapFragment)
                .commit();
    }

}
