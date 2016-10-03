package com.calculator.miron.work_01.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQL.ToDo";
    public static final String TABLE_REMINDER = "reminders";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_TAG = "tags";
    public static final String KEY_DATE = "date";
    public static final String KEY_TIME = "time";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_REMINDER + "(" + KEY_ID + " integer primary key," + KEY_TITLE + " text,"
                + KEY_CONTENT + " text," + KEY_CATEGORY + " text," + KEY_TAG + " text,"
                + KEY_DATE + " text," + KEY_TIME + " text" + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_REMINDER);

        onCreate(db);


    }



}
