package com.calculator.miron.work_01.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todoDB";
    public static final String TABLE_REMINDER = "reminders";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DATE = "date";
    public static final String KEY_CATAGORY = "category";
    public static final String KEY_TAGS = "tags";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_REMINDER + "(" + KEY_ID + "integer primary key, "
                + "text" + KEY_TITLE + KEY_CONTENT + "text" + KEY_DATE + "text" + KEY_CATAGORY + "text"
                + KEY_TAGS + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_REMINDER);


        onCreate(db);


    }
}
