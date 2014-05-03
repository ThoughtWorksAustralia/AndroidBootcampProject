package com.thoughtworks.androidbootcamp.controller.fragment;


import android.app.Activity;
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
import com.google.android.gms.maps.model.LatLng;
import com.thoughtworks.androidbootcamp.R;


public class TreasureMapFragment extends Fragment implements GooglePlayServicesClient.ConnectionCallbacks,
        GooglePlayServicesClient.OnConnectionFailedListener {

    private final static String TAG = "TreasureMapFragment";

    private GoogleMap mMap;
    private LocationClient mLocationClient;
    private MapFragment mMapFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity mActivity = this.getActivity();
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
        Toast.makeText(getActivity(), "Connected to Play Services", Toast.LENGTH_SHORT).show();
        mMap = mMapFragment.getMap();
        moveToCurrentLocation();
    }

    @Override
    public void onStop() {
        mLocationClient.disconnect();
        super.onStop();
    }

    @Override
    public void onDisconnected() {
        Toast.makeText(getActivity(), "Disconnected from Play Services", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            Toast.makeText(getActivity(), "Connected to Play Services failed", Toast.LENGTH_SHORT).show();
            //TODO: Display an error message and retry
            //See https://developer.android.com/training/location/retrieve-current.html
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

    private boolean servicesConnected() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
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
