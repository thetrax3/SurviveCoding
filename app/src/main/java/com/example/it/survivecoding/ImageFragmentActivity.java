package com.example.it.survivecoding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.it.survivecoding.fragments.ImageFragment;

public class ImageFragmentActivity extends AppCompatActivity implements ImageFragment.OnImageTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagefragment);

        ImageFragment imageFragment = (ImageFragment) getSupportFragmentManager()
                .findFragmentById(R.id.image_fragment);
        imageFragment.setOnImageTouchListener(this);
    }

    @Override
    public void onImageTouch(ImageView imageView, String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
