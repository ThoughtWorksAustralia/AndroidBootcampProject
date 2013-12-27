package com.thoughtworks.androidbootcamp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.thoughtworks.androidbootcamp.R;

public class WhoAmIActivity extends ActionBarActivity {

    public static final String PLAYER_DATA = "com.thoughtworks.androidbootcamp.PLAYER_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whoami);
        Log.d("lifecycle", "WhoAmI onCreate");
    }

    public void returnPlayer(View view) {

        Intent returnIntent = new Intent();
        returnIntent.putExtra(WhoAmIActivity.PLAYER_DATA, getPlayerName());

        setResult(RESULT_OK, returnIntent);

        finish();
    }

    private String getPlayerName() {
        View playerField = findViewById(R.id.player_field);
        return ((EditText) playerField).getText().toString();
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle", "WhoAmI onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "WhoAmI onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle", "WhoAmI onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "WhoAmI onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle", "WhoAmI onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle", "WhoAmI onRestart");
    }


}
