package com.calculator.miron.work_01.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.calculator.miron.work_01.model.ToDoItem;

import java.util.ArrayList;

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

    private static DBHelper sDBHelper;

    /**
     * Get DBHelper instance
     *
     * @param context Activity context
     * @return DBHelper instance
     */
    public static synchronized DBHelper getsInstance(Context context) {
        if (sDBHelper == null) {
            sDBHelper = new DBHelper(context.getApplicationContext());
        }
        return sDBHelper;
    }

    private DBHelper(Context context) {
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


    public boolean saveTask(ToDoItem toDoItem) {
        if (toDoItem == null) return false;
        long result = -1;

        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DBHelper.KEY_TITLE, toDoItem.getTitle());
        contentValues.put(DBHelper.KEY_CONTENT, toDoItem.getContent());
        contentValues.put(DBHelper.KEY_CATEGORY, toDoItem.getCategory());
        contentValues.put(DBHelper.KEY_TAG, toDoItem.getTag());
        contentValues.put(DBHelper.KEY_DATE, toDoItem.getDate());
        contentValues.put(DBHelper.KEY_TIME, toDoItem.getTime());

        // TODO: 09.11.16 Перед вставкой новой записи нужно проверить что такая запись не существует.
        // Если существует, то вызывать update

        result = database.insert(DBHelper.TABLE_REMINDER, null, contentValues);

        Log.d("mLog", "task was saved success - " + (result > -1) +
                ", ID = " + result +
                ", title = " + toDoItem.getTitle() +
                ", content = " + toDoItem.getContent() +
                ", category = " + toDoItem.getCategory() +
                ", tag = " + toDoItem.getTag() +
                ", date = " + toDoItem.getDate() +
                ", time = " + toDoItem.getTime());

        return result > -1;
    }


    public ArrayList<ToDoItem> createToDoItemList() {
        ArrayList<ToDoItem> Items = new ArrayList<ToDoItem>();

        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.query(DBHelper.TABLE_REMINDER, null, null, null, null, null, null);


        if (cursor.moveToFirst()) {
            int titleIndex = cursor.getColumnIndex(DBHelper.KEY_TITLE);
            int contentIndex = cursor.getColumnIndex(DBHelper.KEY_CONTENT);
            int categoryIndex = cursor.getColumnIndex(DBHelper.KEY_CATEGORY);
            int tagIndex = cursor.getColumnIndex(DBHelper.KEY_TAG);
            int dateIndex = cursor.getColumnIndex(DBHelper.KEY_DATE);
            int timeIndex = cursor.getColumnIndex(DBHelper.KEY_TIME);

            do {Items.add(new ToDoItem(cursor.getString(titleIndex), cursor.getString(contentIndex),
                    cursor.getString(categoryIndex), cursor.getString(tagIndex), cursor.getString(dateIndex),
                    cursor.getString(timeIndex)));


            }while (cursor.moveToNext());


        } else cursor.close();


        return Items;
    }


}
