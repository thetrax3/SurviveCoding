package com.example.it.survivecoding;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.it.survivecoding.fragments.TextFragment;

public class FragmentExam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_exam1);
    }

    private void addFragment(int containerID, int color, String text) {
        TextFragment textFragment = new TextFragment();
        textFragment.setColor(color);
        textFragment.setText(text);

        getSupportFragmentManager().beginTransaction()
                .add(containerID, textFragment)
                .commit();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Button1:
                addFragment(R.id.container_1, Color.RED, "1번 프래그먼트");
                break;
            case R.id.Button2:
                addFragment(R.id.container_2, Color.BLUE, "2번 프래그먼트");
                break;
            case R.id.Button3:
                addFragment(R.id.container_3, Color.GREEN, "3번 프래그먼트");
                break;
        }
    }
}
