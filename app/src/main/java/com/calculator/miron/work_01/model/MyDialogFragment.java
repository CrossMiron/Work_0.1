package com.calculator.miron.work_01.model;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.calculator.miron.work_01.R;
import com.calculator.miron.work_01.sql.DBHelper;

import static com.calculator.miron.work_01.ui.MainActivity.mDBHelper;


public class MyDialogFragment extends DialogFragment implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    public EditText mTitle, mContent, mCategory, mTag, mDate, mTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle(R.string.create_item_name);
        View view = inflater.inflate(R.layout.dialog_fragment, null);
        view.findViewById(R.id.create_item_button_add).setOnClickListener(this);
        view.findViewById(R.id.create_item_button_cancel).setOnClickListener(this);
        mTitle = (EditText) view.findViewById(R.id.create_item_text_title);
        mContent = (EditText) view.findViewById(R.id.create_item_text_content);
        mCategory = (EditText) view.findViewById(R.id.create_item_text_category);
        mTag = (EditText) view.findViewById(R.id.create_item_text_tag);
        mDate = (EditText) view.findViewById(R.id.create_item_text_date);
        mTime = (EditText) view.findViewById(R.id.create_item_text_time);
        return view;


    }









    @Override
    public void onClick(View view) {
        String title = mTitle.getText().toString();
        String content = mContent.getText().toString();
        String category = mCategory.getText().toString();
        String tag = mTag.getText().toString();
        String date = mDate.getText().toString();
        String time = mTime.getText().toString();

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


        Log.d(LOG_TAG, "Dialog 1: " + ((Button) view).getText());
        dismiss();

    }


    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }

}



