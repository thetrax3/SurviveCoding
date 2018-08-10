package com.example.it.survivecoding.MemoApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.adapters.MemoAdapter;
import com.example.it.survivecoding.models.Memo;

import java.util.ArrayList;
import java.util.List;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int REQUEST_CODE_MEMO = 1000;
    private ListView mMemoListView;
    private List<Memo> mMemoList;
    private MemoAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        mMemoListView = findViewById(R.id.memo_list);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        //데이터
        mMemoList = new ArrayList<>();

        //어댑터
        mAdapter = new MemoAdapter(mMemoList);

        //어댑터 연결
        mMemoListView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MemoActivity.this, EditMemoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_MEMO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MEMO) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String content = data.getStringExtra("content");

                //데이터 저장
                mMemoList.add(new Memo(title, content));
                mAdapter.notifyDataSetChanged();

                Toast.makeText(this, "저장", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
