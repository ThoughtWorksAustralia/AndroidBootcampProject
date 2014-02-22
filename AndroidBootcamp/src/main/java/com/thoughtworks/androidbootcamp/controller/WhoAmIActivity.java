package com.thoughtworks.androidbootcamp.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;

import com.thoughtworks.androidbootcamp.R;

public class WhoAmIActivity extends Activity {

    public static final String PLAYER_DATA = "com.thoughtworks.androidbootcamp.PLAYER_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whoami);
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

}
