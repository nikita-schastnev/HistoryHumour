package com.example.nik_schastnev.historyhumour.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nik_schastnev.historyhumour.R;

import java.util.HashSet;
import java.util.Set;

public class SendFragment extends Fragment {

    EditText titleEditTxt;
    EditText descriptionEditTxt;
    Button btnSendPost;
    private Set<Integer> ids = new HashSet<>();

    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_send, container, false);

        btnSendPost = rootView.findViewById(R.id.btn_send_post);

        titleEditTxt = rootView.findViewById(R.id.title_editTxt);
        descriptionEditTxt = rootView.findViewById(R.id.description_editTxt);

        addTextWatcher(titleEditTxt);
        addTextWatcher(descriptionEditTxt);
        btnSendPost.setEnabled(ids.isEmpty());


        return rootView;
    }

    private void addTextWatcher(final EditText editTxt) {
        editTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    ids.add(editTxt.getId());
                } else {
                    ids.remove(editTxt.getId());
                }
                btnSendPost.setEnabled(ids.isEmpty());
            }
        });

        if (TextUtils.isEmpty(editTxt.getText())) {
            ids.add(editTxt.getId());
        }
    }
}
