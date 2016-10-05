package com.calculator.miron.work_01.model;

import java.util.ArrayList;

/**
 * Created by Miron on 05.10.16.
 */

public class Item {

    private String mTitle;
    private String mContent;
    private String mCategory;
    private String mTag;
    private String mDate;
    private String mTime;

    public Item(String title, String content, String category, String tag, String date, String time) {
        this.mTitle = title;
        this.mContent = content;
        this.mCategory = category;
        this.mTag = tag;
        this.mDate = date;
        this.mTime = time;
    }



    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmTag() {
        return mTag;
    }

    public void setmTag(String mTag) {
        this.mTag = mTag;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

  

}