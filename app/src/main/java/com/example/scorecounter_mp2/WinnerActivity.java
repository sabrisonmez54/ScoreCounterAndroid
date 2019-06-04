package com.example.scorecounter_mp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;


public class WinnerActivity extends AppCompatActivity {

    private TextView winnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.WINNER_MESSAGE);
        winnerText = findViewById(R.id.winnerTextView);
        winnerText.setText(message);
    }
}
