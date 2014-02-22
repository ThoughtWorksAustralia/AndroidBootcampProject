package com.thoughtworks.androidbootcamp.controller.fragment;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtworks.androidbootcamp.R;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class HighScoresFragment extends Fragment {


    public HighScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_high_scores, container, false);
    }


}
