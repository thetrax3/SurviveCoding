package com.example.it.survivecoding.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.it.survivecoding.R;

public class TextFragment extends ColorFragment {
    private String mText = "";
    private TextView mTextView;

    public TextFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        TextView textView = view.findViewById(R.id.text_text);
        textView.setText(mText);
        return view;
    }

    public void setText(String text) {
        mText = text;

        if (getView() != null) {
            mTextView.setText(mText);
        }
    }
}
