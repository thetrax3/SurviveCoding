package com.example.it.survivecoding.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.it.survivecoding.models.Memo;

import java.util.ArrayList;
import java.util.List;

public class MemoFacade {

    private MemoDbHelper mDbHelper;

    public MemoFacade(Context context) {
        mDbHelper = new MemoDbHelper(context);
    }

    /**
     * 메모 추가
     *
     * @param title    제목
     * @param contents 내용
     * @return 추가된 row의 id, 만약 에러가 발생되면 -1
     */
    public long insert(String title, String contents) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //이거 한 줄로 됨
        //db.execSQL("INSERT INTO memo (title, contents) VALUES ('" + title + "','" + contents +"')");

        //여기서부터
        ContentValues values = new ContentValues();
        values.put(MemoContract.MemoEntry.COLUMN_NAME_TITLE, title);
        values.put(MemoContract.MemoEntry.COLUMN_NAME_CONTENTS, contents);

        long newRowId = db.insert(MemoContract.MemoEntry.TABLE_NAME, null, values);
        //여기까지가 쿼리 한 줄을 구현한 것

        return newRowId;
    }

    /**
     * 전체 메모 리스트
     *
     * @return 전체 메모
     */
    public List<Memo> getMemoList() {
        ArrayList<Memo> memoArrayList = new ArrayList<>();

        //DB에서 읽어오기
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        //이거랑 아래 코드랑 같다
//      Cursor cursor = db.rawQuery("SELECT * FROM memo", null);

        String[] projection = {
                MemoContract.MemoEntry._ID,
                MemoContract.MemoEntry.COLUMN_NAME_TITLE,
                MemoContract.MemoEntry.COLUMN_NAME_CONTENTS
        };

        String selection = MemoContract.MemoEntry.COLUMN_NAME_TITLE;
        String[] selectionArgs = {"My Titles"};


        String sortOrder =
                MemoContract.MemoEntry._ID + " DESC";

        Cursor c = db.query(
                MemoContract.MemoEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                sortOrder
        );

        if (c != null) {
            //커서를 Memo로 변환

            //커서를 처음 항목으로 이동
            //c.moveToFirst();
            while (c.moveToNext()) {
                String title = c.getString(c.getColumnIndexOrThrow(
                        MemoContract.MemoEntry.COLUMN_NAME_TITLE));
                String content = c.getString(c.getColumnIndexOrThrow(
                        MemoContract.MemoEntry.COLUMN_NAME_CONTENTS));
                Memo memo = new Memo(title, content);
                memoArrayList.add(memo);
            }
            //커서 닫기
            c.close();
        }
        return memoArrayList;
    }
}
