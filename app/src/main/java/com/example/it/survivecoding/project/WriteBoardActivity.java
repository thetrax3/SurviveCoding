package com.example.it.survivecoding.project;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.it.survivecoding.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WriteBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<EditText> textList;
    private EditText editTitle;
    private EditText editContext;

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_board);

        editTitle = findViewById(R.id.edit_title);
        editContext = findViewById(R.id.edit_context);
        Button postBtn = findViewById(R.id.post_btn);
        Button cancelBtn = findViewById(R.id.cancel_btn);

        textList = new ArrayList<EditText>();

        textList.add(editTitle);
        textList.add(editContext);

        postBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_btn:
                //DB로 데이터를 넘기고 전체/일부 공개로 포스트
                post();
                break;
            case R.id.cancel_btn:
                //이전 페이지로 넘어가도록 설정

                break;
        }
    }

    private void post() {
        if (!isfill()) {
            Toast.makeText(this, "제목과 본문은 빈 칸일 수 없습니다", Toast.LENGTH_SHORT).show();
        } else {
            //문제 없을 시
            final String Title = editTitle.getText().toString();
            final String Context = editContext.getText().toString();

            Response.Listener<String> responseListener = new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(WriteBoardActivity.this);
                            dialog = builder.setMessage("Enable")
                                    .setPositiveButton("OK", null)
                                    .create();
                            dialog.show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(WriteBoardActivity.this);
                            dialog = builder.setMessage("UnEnable")
                                    .setNegativeButton("RETRY", null)
                                    .create();
                            dialog.show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

/*
            RegisterRequest registerRequest = new RegisterRequest(userID, userPwd, userName, userEmail, responseListener);
            RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
            queue.add(registerRequest);//registerRequest에서 받은 정보를 추가하는 부분
*/

            finish();
        }
    }

    private boolean isfill() {
        for (EditText editText : textList) {
            if (TextUtils.isEmpty(editText.getText().toString()))
                return false;
        }
        return true;
    }
}
