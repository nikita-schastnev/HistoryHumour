package com.example.nik_schastnev.historyhumour.new_time;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nik_schastnev.historyhumour.R;

public class NewTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_time);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toNewTimeRussiaActivity(View view) {
        Intent intent = new Intent(this, NewTimeRussiaActivity.class);
        startActivity(intent);
    }

    public void toNewTimeEuropeActivity(View view) {
        Intent intent = new Intent(this, NewTimeEuropeActivity.class);
        startActivity(intent);
    }

    public void toNewTimeUsaActivity(View view) {
        Intent intent = new Intent(this, NewTimeUsaActivity.class);
        startActivity(intent);
    }
}
