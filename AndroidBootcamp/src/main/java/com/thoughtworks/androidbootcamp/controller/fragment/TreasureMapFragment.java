package com.thoughtworks.androidbootcamp.controller.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.HelloAndroid;
import com.thoughtworks.androidbootcamp.model.Locatable;

import java.util.List;

import static com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_GREEN;
import static com.google.android.gms.maps.model.BitmapDescriptorFactory.HUE_YELLOW;


public class TreasureMapFragment extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    private final static String TAG = "TreasureMapFragment";

    private GoogleMap mMap;
    private LocationClient mLocationClient;
    private MapFragment mMapFragment;
    private HelloAndroid mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (HelloAndroid) this.getActivity();
        mLocationClient = new LocationClient(mActivity, this, this);
    }

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

    @Override
    public void onStart() {
        super.onStart();
        mLocationClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(mActivity, "Connected to Play Services", Toast.LENGTH_SHORT).show();
        mMap = mMapFragment.getMap();
        moveToCurrentLocation();
        setMarkers(mActivity.getAttempts(), HUE_GREEN);
        if (mActivity.hasEnded()) {
            setMarkers(mActivity.getTreasures(), HUE_YELLOW);
        }
    }

    @Override
    public void onStop() {
        mLocationClient.disconnect();
        super.onStop();
    }

    @Override
    public void onDisconnected() {
        Toast.makeText(mActivity, "Disconnected from Play Services", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            Toast.makeText(mActivity, "Connected to Play Services failed", Toast.LENGTH_SHORT).show();
            //TODO: Display an error message and retry
            //See https://developer.android.com/training/location/retrieve-current.html
        }
    }

    public void setMarkers(List<? extends Locatable> locatables, float hue) {
        if (canUseMap()) {
            for (Locatable locatable : locatables) {
                mMap.addMarker(createMarkerForLocatable(locatable, hue));
            }
        }
    }

    private boolean canUseMap() {
        return mMap != null & servicesConnected();
    }

    private void moveToCurrentLocation() {
        if (canUseMap()) {
            mMap.setMyLocationEnabled(true);
            Location myLocation = mLocationClient.getLastLocation();
            if (myLocation != null) {
                LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 16.0f);
                mMap.animateCamera(cameraUpdate);
            }
        }
    }

    private MarkerOptions createMarkerForLocatable(Locatable locatable, float hue) {
        LatLng position = new LatLng(
                locatable.getLatitude(),
                locatable.getLongitude());
        MarkerOptions markerOption = new MarkerOptions();
        markerOption
                .position(position)
                .title(locatable.getName())
                .icon(BitmapDescriptorFactory.defaultMarker(hue));
        return markerOption;
    }

    private boolean servicesConnected() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mActivity);
        if (ConnectionResult.SUCCESS == resultCode) {
            Log.d("Location Updates", "Google Play services is available.");
            return true;
        } else {
            //TODO: Handle the failure
            //See https://developer.android.com/training/location/retrieve-current.html
            Log.e(TAG, "Could not connect to play services.");
            return false;
        }
    }

}
