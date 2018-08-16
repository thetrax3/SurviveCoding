package com.example.it.survivecoding.lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.it.survivecoding.R;

public class LifeCycleActivity extends AppCompatActivity {

    private String Tag = LifeCycleActivity.class.getSimpleName();

    private TextView mScoreTextView;
    private int mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_activity);

        mScoreTextView = findViewById(R.id.score_textView);
        setScore(mScore);


        Log.d(Tag, "OnCreate: ");

        //score복원
        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score");
            setScore(mScore);
        }
    }

    private void setScore(int score) {
        mScoreTextView.setText("점수: " + score);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "onStart:");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "onResum:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "onPause:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "onStop:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Tag, "onRestart:");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "onDestroy:");
    }

    //인스턴스 상태 저장
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(Tag, "onSvaeInstanceState");
        outState.putInt("score", mScore);
    }

    public void onClick(View view) {
        mScore += 100;
        setScore(mScore);
    }
}
