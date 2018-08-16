package com.example.it.survivecoding;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.it.survivecoding.fragments.ColorFragment;

public class ColorFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_fragment);

        //xml에서 프래그먼트 가져오기
        ColorFragment colorFragment = (ColorFragment) getSupportFragmentManager().findFragmentById(R.id.color_frag);
        colorFragment.setColor(Color.BLUE);

        //동적으로 프레그먼트를 추가(코드로 추가하는 방법)
        ColorFragment colorFragment2 = new ColorFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, colorFragment2)
                .commit();

    }

    public void onClick(View view) {
        ColorFragment newColorFragment = new ColorFragment();
        int color = Color.YELLOW;

        //기존의 프래그먼트를 교체
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, newColorFragment)
                .commit();

    }
}
