package com.example.nik_schastnev.historyhumour.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.nik_schastnev.historyhumour.recyclerview.FirebaseDatabaseHelper;
import com.example.nik_schastnev.historyhumour.recyclerview.Post;
import com.example.nik_schastnev.historyhumour.R;
import com.example.nik_schastnev.historyhumour.recyclerview.RecyclerViewConfig;

import java.util.List;
import java.util.Objects;

public class BestFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressCircle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_best, container, false);

        mProgressCircle = (ProgressBar) rootView.findViewById(R.id.progress_circle);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        new FirebaseDatabaseHelper().readBest(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Post> posts, List<String> keys) {
                new RecyclerViewConfig().setConfig(mRecyclerView, Objects.requireNonNull(getContext()),
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

        return rootView;
    }

}
