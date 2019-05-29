package com.example.nik_schastnev.historyhumour.antiquity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nik_schastnev.historyhumour.R;

public class AntiquityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antiquity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void toAncientEgyptActivity(View view) {
        Intent intent = new Intent(this, AncientEgyptActivity.class);
        startActivity(intent);
    }

    public void toAncientGreeceActivity(View view) {
        Intent intent = new Intent(this, AncientGreeceActivity.class);
        startActivity(intent);
    }

    public void toAncientRomeActivity(View view) {
        Intent intent = new Intent(this, AncientRomeActivity.class);
        startActivity(intent);
    }
}
