package com.example.nik_schastnev.historyhumour.twenty_first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.nik_schastnev.historyhumour.R;
import com.example.nik_schastnev.historyhumour.recyclerview.FirebaseDatabaseHelper;
import com.example.nik_schastnev.historyhumour.recyclerview.Post;
import com.example.nik_schastnev.historyhumour.recyclerview.RecyclerViewConfig;

import java.util.List;

public class TwentyFirstActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twenty_first);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mProgressCircle = (ProgressBar) findViewById(R.id.progress_circle);

        new FirebaseDatabaseHelper().readTwentyFirst(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Post> posts, List<String> keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView, TwentyFirstActivity.this,
                        posts, keys);

                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void DataIsInserted() {}

            @Override
            public void DataIsUpdated() {}

            @Override
            public void DataIsDeleted() {}
        });

    }
}