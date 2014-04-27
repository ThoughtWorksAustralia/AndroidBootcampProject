package com.thoughtworks.androidbootcamp.controller.fragment;



import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.adapter.HighScoreAdapter;
import com.thoughtworks.androidbootcamp.model.Score;
import com.thoughtworks.androidbootcamp.util.Properties;
import com.thoughtworks.androidbootcamp.util.TreasureService;

import java.util.List;

import retrofit.RestAdapter;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class HighScoresFragment extends Fragment {


    private TreasureService mTreasureService;
    private List<Score> mHighScores;
    private HighScoreAdapter mHighScoreAdapter;

    public HighScoresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTreasureService =  new RestAdapter.Builder()
                .setEndpoint(Properties.SERVICE_URL)
                .build()
                .create(TreasureService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_high_scores, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ListView listView = (ListView) view.findViewById(R.id.high_score_list);
        new AsyncTask<Void, Void, List<Score>>() {
            @Override
            protected List<Score> doInBackground(Void... voids) {
                return mTreasureService.listHighScores();
            }

            @Override
            protected void onPostExecute(List<Score> highScores) {
                mHighScores = highScores;
                mHighScoreAdapter = new HighScoreAdapter(getActivity(), mHighScores);
                listView.setAdapter(mHighScoreAdapter);
            }
        }.execute();
    }


}
