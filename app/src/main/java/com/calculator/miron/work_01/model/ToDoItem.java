package com.calculator.miron.work_01.model;

import java.util.ArrayList;

/**
 * Created by Miron on 05.10.16.
 */

public class ToDoItem {

    private String mTitle;
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