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
        team1Score = findViewById(R.id.team1score);
        team2Score = findViewById(R.id.textView2);
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
}
