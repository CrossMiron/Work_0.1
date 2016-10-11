package com.calculator.miron.work_01.sql;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.calculator.miron.work_01.ui.MainActivity.mDBHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "todo";
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


    public void saveTask (String title, String content, String category, String tag,
                          String date, String time) {
        
        SQLiteDatabase database = mDBHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_TITLE, title);
        contentValues.put(DBHelper.KEY_CONTENT, content);
        contentValues.put(DBHelper.KEY_CATEGORY, category);
        contentValues.put(DBHelper.KEY_TAG, tag);
        contentValues.put(DBHelper.KEY_DATE, date);
        contentValues.put(DBHelper.KEY_TIME, time);

        database.insert(DBHelper.TABLE_REMINDER, null, contentValues);

        Cursor cursor = database.query(DBHelper.TABLE_REMINDER, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int titleIndex = cursor.getColumnIndex(DBHelper.KEY_TITLE);
            int contentIndex = cursor.getColumnIndex(DBHelper.KEY_CONTENT);
            int categoryIndex = cursor.getColumnIndex(DBHelper.KEY_CATEGORY);
            int tagIndex = cursor.getColumnIndex(DBHelper.KEY_TAG);
            int dateIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            int timeIndex = cursor.getColumnIndex(DBHelper.KEY_TIME);


            do {
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", title = " + cursor.getString(titleIndex) +
                        ", content = " + cursor.getString(contentIndex) +
                        ", category = " + cursor.getString(categoryIndex) +
                        ", tag = " + cursor.getString(tagIndex) +
                        ", date = " + cursor.getString(dateIndex) +
                        ", time = " + cursor.getString(timeIndex));
            } while (cursor.moveToNext());
        } else
            Log.d("mLog", "0 rows");

        cursor.close();


    }



}
