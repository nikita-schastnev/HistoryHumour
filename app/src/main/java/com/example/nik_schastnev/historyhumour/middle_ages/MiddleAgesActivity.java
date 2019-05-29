package com.example.nik_schastnev.historyhumour.middle_ages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nik_schastnev.historyhumour.R;

public class MiddleAgesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_ages);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void toMiddleAgesRusActivity(View view) {
        Intent intent = new Intent(this, MiddleAgesRusActivity.class);
        startActivity(intent);
    }

    public void toMiddleAgesEuropeActivity(View view) {
        Intent intent = new Intent(this, MiddleAgesEuropeActivity.class);
        startActivity(intent);
    }

    public void toMiddleAgesAsiaActivity(View view) {
        Intent intent = new Intent(this, MiddleAgesAsiaActivity.class);
        startActivity(intent);
    }

}
