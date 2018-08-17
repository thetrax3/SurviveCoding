package com.example.it.survivecoding.admob;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.it.survivecoding.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class admobActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admob);

        //배너
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
