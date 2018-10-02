package com.example.it.survivecoding.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MemoDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "memo.db";

    public MemoDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //DB를 처음으로 사용할 때
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLE 생성
        db.execSQL(MemoContract.SQL_CREATE_MEMO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //업그레이드 처리
    }
}
