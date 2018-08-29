package com.example.it.survivecoding.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.it.survivecoding.R;

public class ReadBoardActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView viewTitle;
    private TextView viewContext;
    private EditText editReply;
    private ListView listViewReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_board);

        //게시물 내용
        viewTitle = findViewById(R.id.viewTitle);
        viewContext = findViewById(R.id.viewContext);

        //제목과 본문 db에서 호출
        readTitle();
        readContext();

        //댓글 작성
        editReply = findViewById(R.id.editReply);

        //댓글 리스트뷰
        listViewReply = findViewById(R.id.listview_reply);

        //댓글 작성 버튼
        Button replyBtn = findViewById(R.id.reply_btn);
        replyBtn.setOnClickListener(this);
    }

    private void readTitle() {
        //*********************
    }

    private void readContext() {
        //*********************
    }

    @Override
    public void onClick(View v) {
        //작성한 댓글을 게시물 id와 연결해 db에 저장
        //*********************
    }
}
