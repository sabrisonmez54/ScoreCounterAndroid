package com.example.scorecounter_mp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.net.Uri;


public class WinnerActivity extends AppCompatActivity {

    private TextView winnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.WINNER_MESSAGE);
        winnerText = findViewById(R.id.winnerTextView);
        winnerText.setText(message);
    }

    public void sendMessageBtnClicked(View view)
    {

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, winnerText.getText());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }
    public void callBtnClicked(View view)
    {

        Uri uri = Uri.parse("tel:8005551234");
        Intent it = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(it);



    }
    public void mapsBtnClicked(View view)
    {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=arenas");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}