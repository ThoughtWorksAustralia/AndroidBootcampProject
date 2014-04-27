package com.thoughtworks.androidbootcamp.controller.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;
import com.thoughtworks.androidbootcamp.controller.adapter.TreasureListAdapter;
import com.thoughtworks.androidbootcamp.model.Attempt;
import com.thoughtworks.androidbootcamp.model.Game;
import com.thoughtworks.androidbootcamp.model.Locatable;
import com.thoughtworks.androidbootcamp.model.Treasure;
import com.thoughtworks.androidbootcamp.util.FileUtils;
import com.thoughtworks.androidbootcamp.util.Properties;
import com.thoughtworks.androidbootcamp.util.TreasureService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import retrofit.RestAdapter;

import static java.lang.Math.round;
import static java.lang.String.format;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class TreasureListFragment extends Fragment {

    private static final String TAG = "TreasureListFragment";
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    TreasureService treasureService;

    private String mCurrentPhotoPath;
    private Treasure mSelectedTreasure;

    private TreasureListAdapter mTreasureListAdapter;
    List<Treasure> treasureList;
    private Game mGame;

    public TreasureListFragment() {
        // Required empty public constructor
    }

    public Game getGame() {
        return mGame;
    }

    public Treasure getSelectedTreasure() {
        return mSelectedTreasure;
    }

    public String getCurrentPhotoPath() {
        return mCurrentPhotoPath;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        treasureService = new RestAdapter.Builder()
                .setEndpoint(Properties.SERVICE_URL)
                .build()
                .create(TreasureService.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treasure_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final GridView gridView = (GridView) view.findViewById(R.id.treasure_list);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedTreasure = (Treasure) mTreasureListAdapter.getItem(position);
                takePhoto();
            }
        });
        new AsyncTask<Void, Void, List<Treasure>>() {
            @Override
            protected List<Treasure> doInBackground(Void... voids) {
                return treasureService.listTreasures();
            }

            @Override
            protected void onPostExecute(List<Treasure> treasures) {
                HelloAndroid activity = (HelloAndroid) getActivity();
                mGame = activity.getGame();
                mGame.setTreasures(treasures);
                mTreasureListAdapter = new TreasureListAdapter(activity);
                gridView.setAdapter(mTreasureListAdapter);
            }
        }.execute();
    }

    public void takePhoto() {
        // Create a new intent for taking a photo
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Create the File where the photo should go
        try {
            File photoFile = FileUtils.getExternalPublicFile(Environment.DIRECTORY_PICTURES,
                    getString(R.string.app_name));

            // store the path so we know where it is later
            mCurrentPhotoPath = photoFile.getAbsolutePath();

            // tell camera app when to put the photo
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));

            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                // ask to use the camera
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }

        } catch (IOException ex) {
            Log.e(TAG, "Error opening file", ex);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check that its the right result and that it was successful
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            onTreasureAttempted();
        }
    }

    protected void onTreasureAttempted() {
        // Retrieve geocode info from the taken photo and treasure
        Attempt attempt = createAttemptForPhoto(getCurrentPhotoPath());
        attempt.setDistance(calculateDistance(getSelectedTreasure(), attempt));
        getGame().recordAttempt(getSelectedTreasure(), attempt);

        Toast.makeText(getActivity(), format("Your photo is %s metres from treasure", attempt.getDistance()),
                Toast.LENGTH_LONG).show();
    }

    protected Attempt createAttemptForPhoto(String photoPath) {
        try {
            // Note: The built in camera in Genymotion devices does not record geolocation
            // To test this on a Genymotion emulation, you need to install google play store,
            // Download the CameraMX app, turn on location services, set the current location,
            // And select the CameraMX app when you take the photo
            ExifInterface exifInterface = new ExifInterface(new File(photoPath).getCanonicalPath());
            float latlng[] = new float[2];
            exifInterface.getLatLong(latlng);

            return new Attempt(latlng[0], latlng[1], photoPath);

        } catch (IOException e) {
            Log.e(TAG, "Unable to retrieve exif tags from image", e);
            return null;
        }
    }

    protected int calculateDistance(Locatable place1, Locatable place2) {
        Location place1Loc = new Location("place1");
        place1Loc.setLatitude(place1.getLatitude());
        place1Loc.setLongitude(place1.getLongitude());
        Location place2Loc = new Location("place2");
        place2Loc.setLatitude(place2.getLatitude());
        place2Loc.setLongitude(place2.getLongitude());
        return round(place1Loc.distanceTo(place2Loc));
    }
}
