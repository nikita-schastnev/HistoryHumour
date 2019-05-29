package com.example.nik_schastnev.historyhumour.twentieth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nik_schastnev.historyhumour.R;

public class TwentiethActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twentieth);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toWorldWarsActivity(View view) {
        Intent intent = new Intent(this, WorldWarsActivity.class);
        startActivity(intent);
    }

    public void toCommunismActivity(View view) {
        Intent intent = new Intent(this, CommunismActivity.class);
        startActivity(intent);
    }

    public void toSecondHalfActivity(View view) {
        Intent intent = new Intent(this, SecondHalfActivity.class);
        startActivity(intent);
    }

}
