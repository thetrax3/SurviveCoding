package com.example.it.survivecoding.IntentTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.it.survivecoding.R;

public class IntentExam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_exam2);

        if (getIntent() != null) {
            String id = getIntent().getStringExtra("id");
            String pwd = getIntent().getStringExtra("pwd");

            Toast.makeText(this, "id" + id + ", pw=" + pwd, Toast.LENGTH_SHORT).show();

        }
    }

    public void onClick(View view) {
        //누른 버튼에서 정보를 받아오는 방법
        String text = ((Button) view).getText().toString();

        Intent intent = new Intent();
        intent.putExtra("result", text);

        setResult(RESULT_OK, intent);
        finish();
    }
}
