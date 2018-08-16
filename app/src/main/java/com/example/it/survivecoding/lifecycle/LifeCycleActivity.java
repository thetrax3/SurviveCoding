package com.example.it.survivecoding.lifecycle;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

        //score복원을 여기에 넣어도 됨
        /*if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("score");
            setScore(mScore);
        }*/

        //읽어오기
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        mScore = sharedPreferences.getInt("score", 0);
    }


    //복원
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

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

        //저장
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", mScore);
        //editor.commit(); //동기(sync)
        editor.apply(); //비동기(async)

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
