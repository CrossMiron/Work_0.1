package com.calculator.miron.work_01.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.calculator.miron.work_01.sql.DBHelper;

import java.util.ArrayList;

import static com.calculator.miron.work_01.ui.MainActivity.mDBHelper;

/**
 * Created by Miron on 05.10.16.
 */

public class ToDoItem {

    public String mTitle;
    private String mContent;
    private String mCategory;
    private String mTag;
    private String mDate;
    private String mTime;

    public ToDoItem(String title, String content, String category, String tag, String date, String time) {
        this.mTitle = title;
        this.mContent = content;
        this.mCategory = category;
        this.mTag = tag;
        this.mDate = date;
        this.mTime = time;
    }



    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getTag() {
        return mTag;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }






}