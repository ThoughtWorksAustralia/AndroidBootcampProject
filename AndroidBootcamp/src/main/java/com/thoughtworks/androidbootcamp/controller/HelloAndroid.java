package com.thoughtworks.androidbootcamp.controller;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.thoughtworks.androidbootcamp.R;
import com.thoughtworks.androidbootcamp.controller.fragment.HighScoresFragment;
import com.thoughtworks.androidbootcamp.controller.fragment.TreasureListFragment;
import com.thoughtworks.androidbootcamp.controller.fragment.TreasureMapFragment;
import com.thoughtworks.androidbootcamp.model.Attempt;
import com.thoughtworks.androidbootcamp.model.Game;
import com.thoughtworks.androidbootcamp.model.Treasure;
import com.thoughtworks.androidbootcamp.util.TreasureLoader;

import java.util.List;

import static java.lang.String.format;

public class HelloAndroid extends Activity implements ActionBar.OnNavigationListener {

    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    private static final String STATE_GAME = "game_state";
    private static final int PROMPT_FOR_PLAYER = 1000;
    private Game mGame;
    private TreasureLoader treasureLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        treasureLoader = new TreasureLoader(this);
        treasureLoader.copySampleImages();

        // Set up the action bar to show a dropdown list.
        final android.app.ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<String>(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new String[]{
                                getString(R.string.title_section1),
                                getString(R.string.title_section2),
                                getString(R.string.title_section3),
                        }),
                this);
        if (savedInstanceState == null) {
            promptForPlayer();
        }
    }



    private void promptForPlayer() {
        Intent i = new Intent(this, WhoAmIActivity.class);
        startActivityForResult(i, PROMPT_FOR_PLAYER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PROMPT_FOR_PLAYER) {
            if (resultCode == RESULT_OK) {
                getGame().setPlayer(data.getStringExtra(WhoAmIActivity.PLAYER_DATA));
                welcomePlayer();
            }
        }
    }

    private void welcomePlayer() {
        Toast.makeText(this, "Welcome "+getGame().getPlayer(), Toast.LENGTH_LONG);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
        if (savedInstanceState.containsKey(STATE_GAME)) {
            mGame = (Game) savedInstanceState.getSerializable(STATE_GAME);
            welcomePlayer();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
        outState.putSerializable(STATE_GAME, getGame());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello_android, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int position, long id) {
        switch (position) {
            case 0:
                showTreasureList();
                break;
            case 1:
                showHighScores();
                break;
            case 2:
                showMap();
                break;
        }
        return true;
    }

    protected void showMap() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new TreasureMapFragment())
                .commit();
    }

    protected void showTreasureList() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new TreasureListFragment())
                .commit();
    }

    protected void showHighScores() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new HighScoresFragment())
                .commit();
    }

    public void setTreasures(List<Treasure> treasures) {
        getGame().setTreasures(treasures);
    }

    public Game getGame() {
        if (mGame == null) {
            mGame = new Game();
        }
        return mGame;
    }

    public List<Treasure> getTreasures() {
        return getGame().getTreasures();
    }

    public List<Attempt> getAttempts() {
        return getGame().getAttempts();
    }

    public boolean hasEnded() {
        return getGame().hasEnded();
    }

    public void endGame(View view) {
        getGame().end();
        Toast.makeText(this, getEndGameMessage(), Toast.LENGTH_LONG).show();
    }

    protected String getEndGameMessage() {
        return format("Good game! Your final score was %d. \n" +
                "Check out the Treasure Map to see where all the treasures are.", getScore());
    }


    public int getScore() {
        return getGame().getScore().getScore();
    }
}
