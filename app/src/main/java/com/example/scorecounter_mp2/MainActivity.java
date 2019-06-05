package com.example.scorecounter_mp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar spinner;
    private int t1Count = 0;
    private int t2Count = 0;
    private TextView team1Name;
    private TextView team2Name;
    private TextView team1Score;
    private TextView team2Score;
    public static final String WINNER_MESSAGE =
            "com.example.android.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);
        team1Name = findViewById(R.id.team1name);
        team1Score = findViewById(R.id.team1score);
        team2Name = findViewById(R.id.team2name);
        team2Score = findViewById(R.id.textView2);

        if (savedInstanceState != null) {
            boolean isVisible =
                    savedInstanceState.getBoolean("score_visible");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible) {
                team1Score.setVisibility(View.VISIBLE);
                team1Score.setText(savedInstanceState
                        .getString("score_text1"));
                team2Score.setVisibility(View.VISIBLE);
                team2Score.setText(savedInstanceState
                        .getString("score_text2"));
                t1Count = savedInstanceState.getInt("score_count1");
                t2Count = savedInstanceState.getInt("score_count2");
            }
        }
    }

    public void team1Up(View view)
    {
        t1Count++;
        team1Score.setText(Integer.toString(t1Count));
        checkScore();
    }

    public void team1Down(View view)
    {
        t1Count--;
        team1Score.setText(Integer.toString(t1Count));
        checkScore();
    }

    public void team2Up(View view)
    {
        t2Count++;
        team2Score.setText(Integer.toString(t2Count));
        checkScore();
    }

    public void team2Down(View view)
    {
        t2Count--;
        team2Score.setText(Integer.toString(t2Count));
        checkScore();
    }

    public void checkScore()
    {

        Intent intent = new Intent(this, WinnerActivity.class);

        if(t1Count == 5)
        {
            spinner.setVisibility(View.VISIBLE);
            int difference = t1Count-t2Count;
            String message = ("Team 1 won by " + difference + " points");
            intent.putExtra(WINNER_MESSAGE, message);

            startActivity(intent);
            spinner.setVisibility(View.GONE);
        }

        if(t2Count == 5)
        {
            spinner.setVisibility(View.VISIBLE);
            int difference = t2Count-t1Count;
            String message = ("Team 2 won by " + difference + " points");
            intent.putExtra(WINNER_MESSAGE, message);
            startActivity(intent);
            spinner.setVisibility(View.GONE);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (team1Score.getVisibility() == View.VISIBLE) {
            outState.putBoolean("score_visible", true);
            outState.putInt("score_count1", t1Count);
            outState.putString("score_text1",
                    team1Score.getText().toString());
            outState.putInt("score_count2", t2Count);
            outState.putString("score_text2",
                    team2Score.getText().toString());
        }
    }
}
