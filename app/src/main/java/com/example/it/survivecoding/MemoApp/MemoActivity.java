package com.example.it.survivecoding.MemoApp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.adapters.MemoAdapter;
import com.example.it.survivecoding.db.MemoDbHelper;
import com.example.it.survivecoding.db.MemoFacade;
import com.example.it.survivecoding.models.Memo;

import java.util.List;

public class MemoActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    public static final int REQUEST_CODE_NEW_MEMO = 1000;
    private static final int REQUEST_CODE_UPDATE_MEMO = 1001;

    private List<Memo> mMemoList;
    private MemoAdapter mAdapter;
    private ListView mMemoListView;

    private MemoDbHelper mDbHelper;
    private MemoFacade mMemoFacade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        //DB헬퍼
        mDbHelper = new MemoDbHelper(this);

        //메모 퍼사드
        mMemoFacade = new MemoFacade(this);
        mMemoListView = findViewById(R.id.memo_list);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        //데이터
        mMemoList = mMemoFacade.getMemoList();

        //어댑터
        mAdapter = new MemoAdapter(mMemoList);

        //어댑터 연결
        mMemoListView.setAdapter(mAdapter);

        //이벤트
        mMemoListView.setOnItemClickListener(this);

        //ContextMenu
        registerForContextMenu(mMemoListView);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MemoActivity.this, EditMemoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NEW_MEMO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(String.valueOf(requestCode), "save1: 1");
        if (resultCode == RESULT_OK) {

            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");

            if (requestCode == REQUEST_CODE_NEW_MEMO) {
                // 새 메모
                //DB사용 안할때는 list에 add해주지만 db를 사용하면 ㄴㄴ
                //mMemoList.add(new Memo(title, content));

                long newRowId = mMemoFacade.insert(title, content);

                if (newRowId == -1) {
                    //error
                    Toast.makeText(this, "save fail", Toast.LENGTH_SHORT).show();
                } else {
                    //success
                    //리스트 갱신
                    mMemoList = mMemoFacade.getMemoList();
                }

            } else if (requestCode == REQUEST_CODE_UPDATE_MEMO) {
                long id = data.getLongExtra("id", -1);

                //수정
                Memo memo = mMemoList.get((int) id);
                memo.setTitle(title);
                memo.setContent(content);
            }
            //mAdapter.notifyDataSetChanged();
            // TODO 위 코드가 버그나서 안되니 일단 아래 코드로 땜빵
            mAdapter = new MemoAdapter(mMemoList);
            mMemoListView.setAdapter(mAdapter);

            Toast.makeText(this, "저장", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "취소", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Memo memo = mMemoList.get(position);

        Intent intent = new Intent(this, EditMemoActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("memo", String.valueOf(memo));

        startActivityForResult(intent, REQUEST_CODE_UPDATE_MEMO);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_memo, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("확인");
                builder.setMessage("정말 삭제하시겠습니까?");
                builder.setIcon(R.mipmap.ic_launcher);
                //긍정 버튼
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteMemo(info.id);
                    }
                });
                //부정 버튼
                builder.setNegativeButton("취소", null);
                builder.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteMemo(long id) {
        mMemoList.remove((int) id);
        mAdapter.notifyDataSetChanged();
    }
}
